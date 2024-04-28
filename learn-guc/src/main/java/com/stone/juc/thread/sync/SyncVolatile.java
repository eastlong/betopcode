package com.stone.juc.thread.sync;

/**
 * @Description:
 * @Date 2024/01/20 17:29:00
 **/
public class SyncVolatile implements Runnable {
     volatile int value=0;
     volatile int count=0;

    @Override
    public void run() {
        for(int i=0;i<100;i++){
            value = value + 1;
        }
        count = count + 1;
    }

    public static void main(String[] args) {
        SyncVolatile test = new SyncVolatile();
        for(int i=0;i<10;i++){
            Thread t=new Thread(test);
            t.start();
        }
        while(test.count!=5);
        System.out.println(test.value);
    }
}
