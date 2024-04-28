package com.stone.juc.thread.sync;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Description:
 * @Date 2024/01/19 09:55:00
 **/
public class ExecutorsTest implements ThreadFactory {
    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        return null;
    }

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(10);
        Executors.newScheduledThreadPool(5);
    }
}
