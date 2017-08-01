package com.terryx.leecode.contest43;

/**
 * @author taoranxue on 8/1/17 5:40 PM.
 */
public class Solution650 {
    public int minSteps(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 0;
        for (int i = 1; i <= n; ++ i) {
            if (i + i <= n) {
                dp[i + i] = dp[i] + 2;
            }
            for (int j = i + 2 * i; j <= n; j += i) {
                dp[j] = dp[j - i] + 1;
            }
        }
        return dp[n];
    }
}
