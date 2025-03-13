package com.pitaya.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 */
public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        // 将字典列表转换为哈希集合，提高查询效率（O(1)时间复杂度）
        Set<String> wordSet = new HashSet<>(wordDict);
        // dp数组，dp[i]表示前i个字符是否可以拆分成字典中的单词
        boolean[] dp = new boolean[s.length() + 1];

        // 初始化dp数组，第一个字符可以拆分成空字符串
        dp[0] = true;

        // 遍历所有可能的子字符串结束位置（从1到完整字符串长度）
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j ++) {
                // 检查所有可能的拆分点j（j的范围是0到i-1）
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // 返回整个字符串的可拆分状态
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }
}

/**
 * 139. 单词拆分
 * https://leetcode.cn/problems/word-break/description/
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 */
