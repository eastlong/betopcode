package com.pitaya.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 15.三数之和
 * @Date 2024/05/05 15:32:00
 **/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //定义一个结果集
        List<List<Integer>> res = new ArrayList<>();
        //数组的长度
        int len = nums.length;
        //当前数组的长度为空，或者长度小于3时，直接退出
        if(nums == null || len <3){
            return res;
        }
        // 将数组进行排序
        Arrays.sort(nums);
        // 遍历数组中的每一个元素
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) return res;

            if (i > 0 && nums[i] == nums[i-1]) continue; // 遇到相同的值，跳过，因为上一轮已经计算过了

            int cur = nums[i];
            int L = i + 1; // 数字不能重复，从i+1开始
            int R = len - 1;
            while (L < R) {
                int tmp = cur + nums[L] + nums[R];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    res.add(list);
                    while (L<R && nums[L+1]==nums[L]) L++; // 当L遇到重复的值，直接跳过
                    while (L<R && nums[R-1]==nums[R]) R--; // 当R遇到重复的值，直接跳过
                    // 当遇到符合条件的组合，L和R都需要往前移动
                    L++;
                    R--;
                } else if (tmp < 0) {
                    L++;
                } else {
                    R--;
                }
            }

        }

        return res;
    }
}

/**
 * 【15.三数之和】 https://leetcode.cn/problems/3sum/description/
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 *
 * 你返回所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 *
 * 【排序 + 双指针】
 * https://leetcode.cn/problems/3sum/solutions/39722/pai-xu-shuang-zhi-zhen-zhu-xing-jie-shi-python3-by/
 *
 */
