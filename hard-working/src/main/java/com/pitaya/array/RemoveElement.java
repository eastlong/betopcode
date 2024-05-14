package com.pitaya.array;

import java.util.Arrays;

/**
 * @Description: 移除元素
 * @Date 2024/05/12 23:27:00
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length; // right有富余 用 nums.length-1 更好理解
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1]; // 把最后面的元素移动到当前位置，变相地移除了元素
                right --;
            } else {
                left ++; // 向前移动
            }
        }

        return left; // left指向的是恰好是最新的长度
    }

    // [0,1,2,2,3,0,4,2] --> 2
    public static void main(String[] args) {
        int[] nums = new int[] {0,1,2,2,3,0,4,2};
        int i = removeElement2(nums, 2);
        System.out.println(i);
    }

    public static int removeElement2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1; // right有富余 用 nums.length-1 更好理解
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right]; // 把最后面的元素移动到当前位置，变相地移除了元素
                right --;
            } else {
                left ++; // 向前移动
            }
        }

        return left; // left指向的是恰好是最新的长度
    }


}

















/**
 * 【27.移除元素】
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：2, nums = [2,2]
 * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
 * 示例 2：
 *
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,3,0,4]
 * 解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 */