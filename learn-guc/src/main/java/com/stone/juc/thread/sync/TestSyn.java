package com.stone.juc.thread.sync;

/**
 * @Description:
 * @Date 2024/01/18 15:43:00
 **/
public class TestSyn {
    public static void main(String[] args) {

        MyTicket myTicket = new MyTicket();
        Thread thread1 = new Thread(myTicket,"黄牛1");
        Thread thread2 = new Thread(myTicket,"黄牛2");
        Thread thread3 = new Thread(myTicket,"观众");

        thread1.start();
        thread2.start();
        thread3.start();
    }



    static class MyTicket implements  Runnable{
        public static volatile int num = 1;
        @Override
        public void run() {
            while(num<=1000){
                if (num<=1000){
                    System.out.println(Thread.currentThread().getName()+"买了第"+num+"张票");
                    num = num + 1;
                }else{
                    System.out.println("票售完了");
                }

//            synchronized ("锁"){//锁是一个Object对象类型 ()里面的值："锁"--固定值、this--对象锁
//                if (num<=1000){
//                    System.out.println(Thread.currentThread().getName()+"买了第"+num+"张票");
//                    num++;
//                }else{
//                    System.out.println("票售完了");
//                }
//            }
            }
        }


}

/*
*synchronized ("锁"){
}
//锁是一个Object对象类型
()里面的值：
    1."锁"--固定值
    2.this--对象锁 只能是同一个对象
    这里是三个对象： 使用了三次 new MyTicket();
        Thread thread1 = new Thread(new MyTicket(),"黄牛1");
        Thread thread2 = new Thread(new MyTicket(),"黄牛2");
        Thread thread3 = new Thread(new MyTicket(),"观众");
     这里是一个对象：使用了一次 new MyTicket(); 注意两次 new Thread()只是代理了一个MyTicket对象申请了两个线程 比喻为一个人有两个账号买票
        MyTicket myTicket = new MyTicket();
        Thread thread1 = new Thread(myTicket,"观众1");
        Thread thread2 = new Thread(myTicket,"观众2");
        Thread thread3 = new Thread(new MyTicket(),"观众");
*/


}