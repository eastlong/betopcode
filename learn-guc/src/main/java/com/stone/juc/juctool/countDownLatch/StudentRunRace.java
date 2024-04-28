package com.stone.juc.juctool.countDownLatch;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * https://github.com/CL0610/Java-concurrency/blob/master/25.%E5%A4%A7%E7%99%BD%E8%AF%9D%E8%AF%B4java%E5%B9%B6%E5%8F%91%E5%B7%A5%E5%85%B7%E7%B1%BB-CountDownLatch%EF%BC%8CCyclicBarrier/%E5%A4%A7%E7%99%BD%E8%AF%9D%E8%AF%B4java%E5%B9%B6%E5%8F%91%E5%B7%A5%E5%85%B7%E7%B1%BB-CountDownLatch%EF%BC%8CCyclicBarrier.md
 * @Date 2024/02/27 09:51:00
 **/
public class StudentRunRace {
    CountDownLatch stopLatch = new CountDownLatch(1);
    CountDownLatch runLatch = new CountDownLatch(10);

    public void waitSignal() throws Exception{
        System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
        stopLatch.await();
        System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
        runLatch.countDown();
    }

    public void waitStop() throws Exception{
        System.out.println("stopLatch value is: " + stopLatch.getCount());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("裁判"+Thread.currentThread().getName()+"即将发布口令");
        stopLatch.countDown(); // 发布口令
        System.out.println("stopLatch value is: " + stopLatch.getCount());
        System.out.println("裁判"+Thread.currentThread().getName()+"已发送口令，正在等待所有选手到达终点");
        runLatch.await();
        System.out.println("所有选手都到达终点");
        System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩排名");
    }

    public static void main(String[] args) {
        Instant inst1 = Instant.now();
        ExecutorService service = Executors.newCachedThreadPool();
        StudentRunRace studentRunRace = new StudentRunRace();
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    studentRunRace.waitSignal(); // 每个线程都等待开始的信号，2s
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            service.execute(runnable);
        }
        try {
            studentRunRace.waitStop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();
        Instant inst2 = Instant.now();
        System.out.println("Inst2 : " + inst2);

        System.out.println("Difference in seconds : " + Duration.between(inst1, inst2).getSeconds());
    }
}
