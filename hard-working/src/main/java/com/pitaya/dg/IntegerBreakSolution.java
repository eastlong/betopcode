package com.pitaya.dg;

/**
 * @Description: 343
 * 整数拆分
 * @Date 2024/02/28 22:37:00
 **/
public class IntegerBreakSolution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++) {
            int curMax = 0;
            for (int j = 1; j < i; j++) {
                curMax = Math.max(curMax, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = curMax;
        }
        return dp[n];

    }
}
