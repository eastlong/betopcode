package com.pitaya.array;

/**
 * @Description: 只出现一次的数字
 * @Date 2024/04/28 23:03:00
 **/
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }

        return single;

    }
}

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 示例 1 ：
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 *
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 *
 * 输入：nums = [1]
 * 输出：1
 *
 * 异或运算有个重要的性质：两个相同数字异或为 0
 * ^ 表示异或运算
 *
 */
