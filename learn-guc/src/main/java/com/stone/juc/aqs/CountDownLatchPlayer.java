package com.stone.juc.aqs;

import java.util.concurrent.CountDownLatch;

/**
 * @Description: 创建大乔、兰陵王、安其拉、哪吒和铠等五个玩家，
 *                  主线程必须在他们都完成确认后，才可以继续运行。
 * @Date 2023/09/05 22:45:00
 **/
public class CountDownLatchPlayer {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Thread 大乔 = new Thread(countDownLatch::countDown);
        Thread 兰陵王 = new Thread(countDownLatch::countDown);
        Thread 安其拉 = new Thread(countDownLatch::countDown);
        Thread 哪吒 = new Thread(countDownLatch::countDown);
        Thread 铠 = new Thread(() -> {
            try {
                // 稍等，上个卫生间，马上到...
                Thread.sleep(1500);
                countDownLatch.countDown();
            } catch (InterruptedException ignored) {}
        });

        大乔.start();
        兰陵王.start();
        安其拉.start();
        哪吒.start();
        铠.start();
        countDownLatch.await();
        System.out.println("所有玩家已经就位！");
    }
}
