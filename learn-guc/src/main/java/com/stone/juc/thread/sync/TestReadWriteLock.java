package com.stone.juc.thread.sync;

/**
 * @Description:
 * ReentrantLock(),意思是"可重入锁"，可以被单个线程多次获取。
 * @Date 2024/01/18 21:19:00
 **/
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    public static void main(String[] args) {
        //获取读和写的锁
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        //获取读锁
        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        //获得写锁
        ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();

        System.out.println("-----------使用接口形式进行表示--------------");
        //使用多态 父类引用子类对象
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //获取读锁
        Lock readLock2 = readWriteLock.readLock();
        //获取写锁
        Lock writeLock2 = readWriteLock.writeLock();

    }


}