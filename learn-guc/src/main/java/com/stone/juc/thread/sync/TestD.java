package com.stone.juc.thread.sync;

/**
 * @Description:
 * Lock 可是首先手动加锁、解锁。 多线程使用的时候必须是同一个锁对象 如果代码出现了异常程序不会自动解锁，最好捕获异常。
 * @Date 2024/01/18 21:18:00
 **/
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TestD {
    public static void main(String[] args) {
        new Thread(new TicketRunnable(),"1号窗口").start();
        new Thread(new TicketRunnable(),"2号窗口").start();

    }
}

class TicketRunnable implements Runnable {
    static int num = 1;
    //创建Lock锁
    static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (num<=1000){
            lock.lock(); //给共享资源上锁
            try{
                if (num<=1000){
                    System.out.println(Thread.currentThread().getName()+"售出了第"+num+"张票");
                    num++;
                }else {
                    System.out.println("票售完了");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();//解锁
            }
        }
    }
}