package com.pitaya.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description:739.每日温度
 * @Date 2024/06/11 22:03:00
 **/
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        // 维护一个存储下标的单调栈，从栈底到栈顶的下标对应的温度列表中的温度依次递减。
        // 栈底 75、74、73 栈顶
        Stack<Integer> stack = new Stack<>();
        int length = T.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            // 出栈的条件：（1）栈非空；（2）当前温度>栈顶温度(下一个更高温度:i是pre的下一个高温的索引)
            // 如果栈不为空，并且当前温度大于栈顶温度，则说明当前温度是栈顶温度的下一个更高温度，
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pre = stack.pop();
                result[pre] = i - pre; // i-pre 表示的是下一个温度是几天后
            }
            // 若栈为空，或者栈顶元素对应的温度小于等于当前温度，然后将 i 进栈
            stack.add(i); // 注意，这里加入的是索引i
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] ints = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));
    }
}

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 */
