package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/30/17 2:08 AM.
 */
public class Solution375 {
    public int getMoneyAmount(int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int len = 1; len < n; ++len) {
            for (int i = 1; i <= n - len; ++i) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}
