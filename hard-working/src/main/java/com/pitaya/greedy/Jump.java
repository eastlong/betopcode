package com.pitaya.greedy;

public class Jump {
    public int jump(int[] nums) {
        int currentMaxDistance = 0;
        int nextMaxDistance = 0;
        int ans = 0;
        for (int i=0; i<nums.length-1; i++) {
            nextMaxDistance = Math.max(nums[i] + i, nextMaxDistance);
            if (i == currentMaxDistance) { // i==currentMaxDistance,表示i遍历到当前覆盖范围的最远距离，要进入下一个范围
                ans ++;
                currentMaxDistance = nextMaxDistance;
            }
        }

        return ans;
    }
}



















/**
 * 45. 跳跃游戏 II
 * https://leetcode.cn/problems/jump-game-ii/description/
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * class Solution {
 *     public int jump(int[] nums) {
 *         int curMaxDistance = 0; // 当前覆盖的最远距离下标
 *         int ans = 0;
 *         int nextMaxDistance = 0;
 *         for (int i = 0; i < nums.length - 1; i++) {
 *             nextMaxDistance = Math.max(nums[i] + i, nextMaxDistance);
 *             if (i == curMaxDistance) { // 遇到当前覆盖的最远距离下标
 *                 curMaxDistance = nextMaxDistance;
 *                 ans ++;
 *             }
 *         }
 *
 *         return ans;
 *     }
 * }
 */
