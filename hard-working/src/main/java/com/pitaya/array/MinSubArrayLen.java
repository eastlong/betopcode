package com.pitaya.array;

/**
 * @Description: 长度最小的子数组（连续）
 * @Date 2024/05/14 22:03:00
 **/
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum > s) {
                result = Math.min(result, right - left + 1);
                sum = sum - left;
                left ++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }


}

/**
 * 【209.长度最小的子数组】
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 * class Solution {
 *
 *     // 滑动窗口
 *     public int minSubArrayLen(int s, int[] nums) {
 *         int left = 0;
 *         int sum = 0;
 *         int result = Integer.MAX_VALUE;
 *         for (int right = 0; right < nums.length; right++) {
 *             sum += nums[right];
 *             while (sum >= s) {
 *                 result = Math.min(result, right - left + 1);
 *                 sum = sum - nums[left];
 *                 left ++;
 *             }
 *         }
 *         return result == Integer.MAX_VALUE ? 0 : result;
 *     }
 * }
 */