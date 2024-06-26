package com.pitaya.array;

/**
 * @Description: 11.盛水最多的容器
 * @Date 2024/05/05 14:12:00
 **/
public class MaxAreaOfContainer {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right -left);
            ans = Math.max(ans, area);
            if (height[left] <= height[right]) {
                left ++; // left,right 谁大谁不动
            } else {
                right --;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(arr);
        System.out.println(maxArea);
    }

}

/**
 * 【11.盛水最多的容器】  https://leetcode.cn/problems/container-with-most-water/description/
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * 双指针
 */
