package com.pitaya.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 找到所有数组中消失的数字
 * @Date 2024/05/02 17:43:00
 **/
public class FindDisappearedNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int idx = (num - 1) % n; // 实际上是计算 num 的索引， 比如：n=8, num=5 ，这里就有: idx = 4,即 5 应该出现在nums[4]
            nums[idx] = nums[idx] + n; // 加i主要是为了后面能与n进行判断，消失的数字，对应的位置肯定是 <= n
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);
        Arrays.toString(nums);
    }

}

/**
 * https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/description/
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 *
 * 示例 1：
 *
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 *
 * 示例 2：
 *
 * 输入：nums = [1,1]
 * 输出：[2]
 */
