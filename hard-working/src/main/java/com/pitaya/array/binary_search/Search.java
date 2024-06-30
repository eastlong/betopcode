package com.pitaya.array.binary_search;

/**
 * @Description: 33. 搜索旋转排序数组
 * @Date 2024/06/04 22:25:00
 **/
public class Search {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 先根据 nums[mid] 与 nums[lo] 的关系判断 mid 是在左段还是右段 [4,5,6,7,8,9,10,11,0,1,2]
            if (nums[mid] >= nums[low]) { // mid在左段
                // 再判断 target 是在 mid 的左边还是右边，从而调整左右边界 lo 和 hi
                if (target >= nums[low] && target < nums[mid]) { // [low, mid]是有序的
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // mid 在右段 [10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
                if (target > nums[mid] && target <= nums[high]) { // [mid, high]是有序的
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, mid = 0;
        while (lo <= hi) {
            mid = lo + ((hi - lo) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }




}

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 *
 * 对于旋转数组 nums = [4,5,6,7,0,1,2]
 * 首先根据 nums[0] 与 target 的关系判断 target 是在左段还是右段。
 *
 * 例如 target = 5, 目标值在左半段，因此在 [4, 5, 6, 7, inf, inf, inf] 这个有序数组里找就行了；
 * 例如 target = 1, 目标值在右半段，因此在 [-inf, -inf, -inf, -inf, 0, 1, 2] 这个有序数组里找就行了。
 * 如此，我们又双叒叕将「旋转数组中找目标值」 转化成了 「有序数组中找目标值」
 *
 * 作者：Sweetiee 🍬
 * 链接：https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/221435/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
