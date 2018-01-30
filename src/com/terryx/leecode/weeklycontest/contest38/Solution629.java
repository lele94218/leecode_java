package com.terryx.leecode.weeklycontest.contest38;

/**
 * @author taoranxue on 6/24/17 10:21 PM.
 */
public class Solution629 {
    public int kInversePairs(int n, int k) {
        if (k == 0) return 1;
        long dp[][] = new long[n + 2][k + 2];
        long mod = 1000000007L;
        dp[1][0] = 1;
        dp[1][1] = 0;
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; ++i) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                dp[i][j] = (dp[i][j] + mod) % mod;
                if (j - i >= 0) {
                    dp[i][j] -= dp[i - 1][j - i];
                    dp[i][j] = (dp[i][j] + mod) % mod;
                }
            }
        }
        return (int) dp[n][k];
    }
    public static void main(String args[]) {
        Solution629 solution629 = new Solution629();
        System.out.println(solution629.kInversePairs(3,2));
    }
}
