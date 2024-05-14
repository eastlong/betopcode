package com.itheima.juc.thread;

/**
 * @Description:
 * @Author wu.xl
 * @Date 2023/07/08 09:40:00
 **/
public class TestFrames {
    public static void main(String[] args) {
        methood1(10);
    }

    private static void methood1(int x) {
        int y = x + 1;
        Object m = method2();
    }

    private static Object method2() {
        Object n = new Object();
        return n;
    }
}
