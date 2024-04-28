package com.stone.juc.thread.bank;

/**
 * @Description:
 * @Date 2024/01/20 17:49:00
 **/
public class SynchronizedThread {
    class Bank {
        private int account = 0;
        public int getAccount() {
            return account;
        }
        /**
         * 用同步方法实现
         *
         * @param money
         */
        public void save(int money) {
            account += money;
        }

        /**
         * 用同步代码块实现
         *
         * @param money
         */
        public void save1(int money) {
            synchronized (this) {
                account += money;
            }
        }
    }

    class NewThread implements Runnable {
        private Bank bank;

        public NewThread(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            for(int i=0;i<1000; i++) {
                bank.save(1);
                System.out.println("账户余额是---"+bank.getAccount());
            }
        }
    }

    /**
     * 建立线程，调用内部类
     */
    public void useThread() {
        Bank bank = new Bank();
        NewThread new_thread = new NewThread(bank);
        System.out.println("线程1");
        Thread thread1 = new Thread(new_thread);
        thread1.start();
        System.out.println("线程2");
        Thread thread2 = new Thread(new_thread);
        thread2.start();
    }

    public static void main(String[] args) {
        SynchronizedThread st = new SynchronizedThread();
        st.useThread();
    }
}
