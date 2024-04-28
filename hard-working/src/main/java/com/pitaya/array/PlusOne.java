package com.pitaya.array;

import java.util.Arrays;

/**
 * @Description:
 * @Date 2024/04/28 22:02:00
 **/
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] ++; // 巧妙地用上了 ++;如果不进位，加一次就行，如果进位，就多次加
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits; // 表示不进位，则停止，如果要进位，则继续循环遍历
        }

        digits = new int[digits.length + 1]; // 走到这一步，说明需要再进一位 数组要扩容
        digits[0] = 1;

        return digits;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,3,4};
        int[] ints = plusOne(arr);
        System.out.println(Arrays.toString(ints));

        int[] arr2 = new int[] {9,9,9};
        int[] ints2 = plusOne(arr2);
        System.out.println(Arrays.toString(ints2));

    }
}


/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 示例 1：
 *
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123。
 * 示例 2：
 *
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321。
 * 示例 3：
 *
 * 输入：digits = [0]
 * 输出：[1]
 */