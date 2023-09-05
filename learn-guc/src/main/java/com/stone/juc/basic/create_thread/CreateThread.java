package com.stone.juc.basic.create_thread;


import org.apache.log4j.Logger;

import java.util.concurrent.FutureTask;

/**
 * @Description:
 * @Author wu.xl
 * @Date 2023/07/08 07:31:00
 **/

public class CreateThread {
    private static Logger log = Logger.getLogger(CreateThread.class);

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.info("== create thread by thread ==");
            }
        };
        t1.start();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log.info("== create thread by runnable ==");
            }
        };
        Thread t2 = new Thread(runnable);
        t2.start();

        // 精简
        Runnable r3 = () -> log.info("== this is t3 thread");
        Thread t3 = new Thread(r3);
        t3.start();

        // 一步到位
        Thread t4 = new Thread(() -> log.info("== this is t3 thread"));
        t4.start();

        FutureTask<Integer> task = new FutureTask<Integer>(() ->{
            log.info("task");
            return 100;
        });
        new Thread(task, "t").start();

        // 主线程阻塞，同步等待 task 执行完毕的结果
        Integer result = task.get();
        log.info(result);


        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }, "tm").start();
    }
}
