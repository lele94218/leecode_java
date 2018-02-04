package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/28/17 11:52 PM.
 */
public class Solution343 {
    public int integerBreak(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j < i; ++j) {
                dp[i] = Math.max(dp[i], Math.max(dp[j], j) * (i - j));
            }
        }
        return dp[n];
    }
}
