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
        // 先枚举子串长度 L
        for (int L = 2; L<=len; L++) {
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

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";

        // 初始化最大回文子串的起点和终点
        int start = 0;
        int end   = 0;

        // 遍历每个位置，当做中心位
        for (int i = 0; i < s.length(); i++) {
            // 分别拿到奇数偶数的回文子串长度
            int len_odd = expandCenter(s,i,i); // 奇数
            int len_even = expandCenter(s,i,i + 1); // 偶数
            // 对比最大的长度
            int len = Math.max(len_odd,len_even);
            // 计算对应最大回文子串的起点和终点
            if (len > end - start){
                start = i - (len - 1)/2; // 这里要注意
                end = i + len/2;
            }
        }
        // 注意：这里的end+1是因为 java自带的左闭右开
        return s.substring(start,end + 1);
    }


    /**
     * 这个方法的功能是以给定的left和right为中心，向左右两边扩展，找到最长的回文子串的长度。
     * @param s             输入的字符串
     * @param left          起始的左边界
     * @param right         起始的右边界
     * @return              回文串的长度
     */
    private static int expandCenter(String s,int left,int right){
        // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
        // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
        // 跳出循环的时候恰好满足 s.charAt(left) ！= s.charAt(right)
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        // 回文串的长度是right-left+1-2 = right - left - 1 (-2是因为多移动2步)
        return right - left - 1;
    }

    public static void main(String[] args) {
        String str = "cabbab";
        String s = longestPalindrome2(str);
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