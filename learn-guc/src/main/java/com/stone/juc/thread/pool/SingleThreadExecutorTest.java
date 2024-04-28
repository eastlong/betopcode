package com.stone.juc.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建只有一个线程的线程池测试
 * 该方法无参数，所有任务都保存队列LinkedBlockingQueue中，核心线程数为1，线程空闲时间为0
 * 等待唯一的单线程来执行任务，并保证所有任务按照指定顺序(FIFO或优先级)执行
 */
public class SingleThreadExecutorTest {
    public static void main(String[] args) {
// 创建仅有单个线程的线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                        System.out.println(Thread.currentThread().getName());
                    }
            );
        }
    }
}
