package com.stone.juc.thread.pool;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * @Description:
 * @Date 2024/01/19 10:22:00
 **/
public class ThreadPoolTest {

    /**
     * 创建定时周期执行的线程池测试
     *
     * schedule(Runnable command, long delay, TimeUnit unit)，延迟一定时间后执行Runnable任务；
     * schedule(Callable callable, long delay, TimeUnit unit)，延迟一定时间后执行Callable任务；
     * scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)，延迟一定时间后，以间隔period时间的频率周期性地执行任务；
     * scheduleWithFixedDelay(Runnable command, long initialDelay, long delay,TimeUnit unit)，与scheduleAtFixedRate()方法很类似，
     * 但是不同的是scheduleWithFixedDelay()方法的周期时间间隔是以上一个任务执行结束到下一个任务开始执行的间隔，而scheduleAtFixedRate()方法的周期时间间隔是以上一个任务开始执行到下一个任务开始执行的间隔，
     * 也就是这一些任务系列的触发时间都是可预知的。
     * ScheduledExecutorService功能强大，对于定时执行的任务，建议多采用该方法。
     *
     * 作者：张老梦
     * 链接：https://www.jianshu.com/p/9ce35af9100e
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    @Test
    public void scheduleThreadPoolTest() {
        // 创建指定核心线程数，但最大线程数是Integer.MAX_VALUE的可定时执行或周期执行任务的线程池
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        // 定时执行一次的任务，延迟1s后执行
//        executorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("scheduleThreadPool");
//                System.out.println(Thread.currentThread().getName() + ", delay 1s");
//            }
//        }, 1, TimeUnit.SECONDS);

        // 周期性地执行任务，延迟2s后，每3s一次地周期性执行任务
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ", every 3s");
            }
        }, 2, 3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        // 定时执行一次的任务，延迟1s后执行
        // 周期性地执行任务，延迟2s后，每3s一次地周期性执行任务
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ", every 3s");
            }
        }, 2, 3, TimeUnit.SECONDS);
    }

}
