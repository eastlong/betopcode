package com.stone.juc.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建固定线程数量的线程池测试
 * 创建一个固定大小的线程池，该方法可指定线程池的固定大小，对于超出的线程会在LinkedBlockingQueue队列中等待
 * 核心线程数可以指定，线程空闲时间为0
 */
public class FixedThreadThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2 * (Runtime.getRuntime().availableProcessors()) + 1);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
                    }
            );
        }
    }
}
