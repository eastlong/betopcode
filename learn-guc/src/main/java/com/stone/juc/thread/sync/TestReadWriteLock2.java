package com.stone.juc.thread.sync;

/**
 * @Description:
 * 读写案例: 实现读写可以互斥进行，可以多个线程同时读，不能同时写，读写操作不能同时进行。
 * 【结论】没有加锁可以看到运行结果读写顺序不一致。
 * @Date 2024/01/18 21:20:00
 **/
public class TestReadWriteLock2 {
    public static void main(String[] args) {
        new Thread(()->{
            new Operator().read();
        },"A").start();

        new Thread(()->{
            new Operator().read();
        },"B").start();

        new Thread(()->{
            new Operator().write();
        },"C").start();

        new Thread(()->{
            new Operator().write();
        },"D").start();
    }
}

class Operator{
    //这个方法就是一个读方法
    public void read(){
        System.out.println(Thread.currentThread().getName()+"开始读操作");
        try{
            Thread.sleep(1000); //模拟读消耗的时间
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束读操作");
    }
    public void write(){
        System.out.println(Thread.currentThread().getName()+"开始写操作");
        try{
            Thread.sleep(1000); //模拟读消耗的时间
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"结束写操作");
    }
}
