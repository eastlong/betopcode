package com.itheima.juc.thread.create;

/**
 * @Description:
 * @Date 2024/05/13 21:54:00
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start();
        for(int i = 0 ; i < 100 ; i++ ){
            System.out.println("main线程" + i);
        }
    }


}

class MyThread extends Thread {
    @Override
    public void run() {
        for(int i = 0 ; i < 100 ; i++ ) {
            System.out.println("子线程输出："+i);
        }
    }
}


