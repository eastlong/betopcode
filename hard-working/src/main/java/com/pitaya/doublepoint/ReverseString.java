package com.pitaya.doublepoint;

/**
 * @Description: 字符串反转
 * @Date 2024/05/22 19:39:00
 **/
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = 0;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;

            left ++;
            right --;
        }
    }
}
