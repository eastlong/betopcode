package com.pitaya;

/**
 * @Description:
 * @Date 2023/11/04 09:03:00
 **/
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums =  {2, 0, 1, 0, 3, 12};
        moveZeroes(nums);
    }
}
