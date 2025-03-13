package com.pitaya.greedy;

public class CnaJump {
    public boolean cnaJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        // coverRange的含义：覆盖范围的坐标索引，初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            // 此处为什么是coverageRange >= nums.length - 1，因为如果能跳到数组的最后一个元素，那么说明可以跳过，不需要再判断了。
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}









/**
 * 55. 跳跃游戏
 * https://leetcode.cn/problems/jump-game/description/
 *
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 * class Solution {
 *     public boolean canJump(int[] nums) {
 *         if (nums.length == 1) {
 *             return true;
 *         }
 *         // 覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
 *         int coverRange = 0;
 *         // 在覆盖范围内更新最大的覆盖范围
 *         for (int i = 0; i <= coverRange; i++) {
 *             coverRange = Math.max(coverRange, i + nums[i]);
 *             if (coverRange >= nums.length - 1) {
 *                 return true;
 *             }
 *         }
 *
 *         return false;
 *     }
 * }
 *
 */
