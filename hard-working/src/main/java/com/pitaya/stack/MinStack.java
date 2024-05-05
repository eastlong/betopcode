package com.pitaya.stack;

import java.util.Stack;

/**
 * @Description: 155. 最小栈
 * @Date 2024/05/05 09:59:00
 **/
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // 发现更小的，则放入 minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    // 删除堆栈顶部的元素
    public void pop() {
        if (stack.pop().equals(minStack.peek())) { // 如果移出的是最小值，则minStack也需要移出
            minStack.pop();
        }
    }

    // 获取堆栈顶部的元素。
    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

    }
}

/**
 * 155. 最小栈  https://leetcode.cn/problems/min-stack/description/
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 */
