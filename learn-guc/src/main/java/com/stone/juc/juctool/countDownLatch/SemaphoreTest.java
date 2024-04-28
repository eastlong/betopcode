package com.stone.juc.juctool.countDownLatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Description:
 * @Date 2024/02/27 18:45:00
 **/
public class SemaphoreTest {
    private static final int THREAD_COUNT = 10;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(5);

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            threadPool.execute(new MyRunnable(i));
        }
        threadPool.shutdown();
    }

    private static class MyRunnable implements Runnable {
        private int index;
        MyRunnable(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            try {
                s.acquire();
                System.out.println("save data -- " + index);
                s.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


