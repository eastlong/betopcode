package com.stone.juc.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 可缓存无界线程池测试
 * 当线程池中的线程空闲时间超过60s则会自动回收该线程，核心线程数为0
 * 当任务超过线程池的线程数则创建新线程。线程池的大小上限为Integer.MAX_VALUE，
 * 可看做是无限大。
 */
public class CacheThreadPoolTest {
    public static void main(String[] args) {
        // 创建可缓存的无界线程池，可以指定线程工厂，也可以不指定线程工厂
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
