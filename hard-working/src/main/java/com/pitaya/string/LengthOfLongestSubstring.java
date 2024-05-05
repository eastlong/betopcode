package com.pitaya.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 *
 *  s = "abcabcbb" --> 3
 * @Date 2023/09/16 15:43:00
 **/
public class LengthOfLongestSubstring {
    /**
     * 什么是滑动窗口？
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     * 如何移动？我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>(); // key：字符; value：字符所在的位置，且为最新的位置
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            // 如果key在map中存在，left需要更新，把队列的左边的元素移出就行了
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1); // left指向最初那个相同元素的下一个
            }

            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1); // i - left + 1 表示窗口的长度
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
