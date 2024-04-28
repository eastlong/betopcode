package com.stone.juc.thread.sync;

/**
 * @Description:
 * @Date 2024/01/18 21:21:00
 **/
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock3 {
    public static void main(String[] args) {
        new Thread(()->{
            new Operator2().read();
        },"A").start();

        new Thread(()->{
            new Operator2().read();
        },"B").start();

        new Thread(()->{
            new Operator2().write();
        },"C").start();

        new Thread(()->{
            new Operator2().write();
        },"D").start();
    }
}

class Operator2 {
    //这个方法就是一个读方法
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void read(){
        readWriteLock.readLock().lock();//读锁上锁
        System.out.println(Thread.currentThread().getName()+"开始读操作");
        try{
            Thread.sleep(1000); //模拟读消耗的时间
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束读操作");
        readWriteLock.readLock().unlock();//读锁解锁
    }
    public void write(){
        readWriteLock.writeLock().lock();//写锁上锁
        System.out.println(Thread.currentThread().getName()+"开始写操作");
        try{
            Thread.sleep(1000); //模拟读消耗的时间
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束写操作");
        readWriteLock.writeLock().unlock();//写锁解锁
    }
}
