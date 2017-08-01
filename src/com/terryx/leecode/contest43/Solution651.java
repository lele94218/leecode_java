package com.terryx.leecode.contest43;

/**
 * @author taoranxue on 8/1/17 7:23 PM.
 */
public class Solution651 {
    public int maxA(int N) {
        int dp[] = new int[N + 1];

        for (int i = 1; i <= N; ++i) {
            dp[i] = i;
        }

        for (int i = 3; i <= N; ++i) {
            int t = 2 * dp[i];
            for (int j = i + 4; j <= N; ++j) {
                dp[j] = Math.max(t + dp[i], dp[j]);
                t += dp[i];
                // System.out.println(j + " " + dp[j]);
            }
        }
        return dp[N];
    }
}
