package com.stone.juc.thread.sync;

/**
 * @Description:
 * @Date 2024/01/18 15:47:00
 **/
public class TestSyn2 {
    public static void main(String[] args) {
        MyTicket2 myTicket2 = new MyTicket2();
        Thread thread1 = new Thread(myTicket2,"黄牛");
        Thread thread2 = new Thread(myTicket2,"观众");
        thread1.start();
        thread2.start();

//        //下面代码配合demo()01
//        MyTicket2 myTicket3 = new MyTicket2();
//        MyTicket2 myTicket4 = new MyTicket2();
//        Thread thread3 = new Thread(myTicket3,"黄牛");
//        Thread thread4 = new Thread(myTicket4,"观众");
//        thread3.start();
//        thread4.start();
    }
}


class MyTicket2 implements Runnable{
    //代表的卖出的票数
    static int num = 1;
    public void run(){
        while(num<=500){
            demo01();
            // demo02();
        }
    }
    /*
       synchronized 修饰成员方法 锁的是this 要锁的对象必须是同一个对象
       synchronized 修饰静态方法 当前锁的类锁 传递对象的字节码.class 同一个类创建出不同的对象
     */
    public  synchronized  static void demo01() {
        if (num<=500){
            System.out.println(Thread.currentThread().getName()+"买了第"+num+"张票");
            num++;
        }else{
            System.out.println("票售完了");
        }
    }

    public  synchronized  void demo02() {
        if (num<=500){
            System.out.println(Thread.currentThread().getName()+"买了第"+num+"张票");
            num++;
        }else{
            System.out.println("票售完了");
        }
    }
}