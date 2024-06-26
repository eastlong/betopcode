package com.pitaya.array;

/**
 * @Description:581.?????????
 * @Date 2024/06/12 07:51:00
 **/
public class FindUnsortedSubarray {
    /**
     * ??????????????????????????????????????
     *
     * ????
     * ????(1 2 3 4 5): ??????????(2) <= ????(??3) <= ??????????(4)
     * ??: 2  6  8  10  4  9  15
     * ??: ???? 9??????? (?????????)?
     *      ???? 6??????? (?????????)?
     * ????:
     *      ??????, ???????????, ??????????? ???????????
     *      ??????, ???????????, ??????????? ???????????
     */
    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int leftDiff = -1;
        int rightDiff = -1;
        //???????????(???????????rightDiff), ????Integer.MIN_VALUE
        int max = nums[0];
        //???????????(???????????leftDiff), ????Integer.MAX_VALUE
        int min = nums[length - 1];
        for (int i = 0; i < length; i++) {
            //????, ?? ??????? ???????, ?????????????, ??rightDiff; ???????
            if (nums[i] < max){
                rightDiff = i;
            } else {
                max = nums[i];
            }
            //????, ?? ??????? ???????, ?????????????, ??leftDiff; ???????
            int index = length - 1 - i;
            if (nums[index] > min){
                leftDiff = index;
            } else {
                min = nums[index];
            }
        }
        return leftDiff != -1 ? rightDiff - leftDiff + 1 : 0;
    }
}

/**
 * ???????? nums ???????? ????? ???????????????????????????????
 *
 * ????????? ?? ????????????
 *
 * ?? 1?
 *
 * ???nums = [2,6,4,8,10,9,15]
 * ???5
 * ???????? [6, 4, 8, 10, 9] ?????????????????????
 * ?? 2?
 *
 * ???nums = [1,2,3,4]
 * ???0
 * ?? 3?
 *
 * ???nums = [1]
 * ???0
 *
 * ??????????????????????????????????????????????????????
 * ???????????????????????????right???right????
 * right????????????right???????right???max??????right???max??right????????right?????????right???????????????
 * left???left???????????????????????????????????????????????????????????
 */
