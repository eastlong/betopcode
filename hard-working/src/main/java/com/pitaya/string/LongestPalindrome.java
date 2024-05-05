package com.pitaya.string;

/**
 * @Description: 5.最长回文子串
 * @Date 2024/05/05 12:52:00
 **/
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        // 递推开始 （下面的步骤主要是来地推dp[i][j]）
        // 先枚举子串长度
        for (int L = 2; L <=len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由L 和 i可以确定右边界，j-i+1=L
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                // 递归公式
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) { // 第i和第j个位置字符相同
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String str = "cabbab";
        String s = longestPalindrome(str);
        System.out.println(s);
    }

}

/**
 * 【5.最长回文子串】
 * https://leetcode.cn/problems/longest-palindromic-substring/description/
 *
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * 。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 我们用 P(i,j) 表示字符串 s 的第 i 到 j 个字母组成的串（下文表示成 s[i:j]）是否为回文串：
 * 只有s[i+1][j-1]是回文串，并且s的第i和j个字母相同时，s[i:j]才会是回文串
 *
 * P(i,j) = {
 *     true --> 如果Si .... Sj是回文串
 *     false --> 其他情况
 * }
 *
 * 其他情况：
 * （1） s[i,j]本身不是一个回文串
 * （2） j>i --> s[i,j]不合法
 */