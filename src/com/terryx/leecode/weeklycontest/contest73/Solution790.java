package com.terryx.leecode.weeklycontest.contest73;

import java.util.*;

/**
 * @author taoranxue on 2/24/18 10:14 PM.
 */
public class Solution790 {
    public int numTilings(int N) {
        long dp[][] = new long[N + 10][3];
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[1][2] = 1;
        dp[0][2] = 1;
        dp[2][2] = 2;
        long mod = 1000000007;
        for (int i = 3; i <= N; ++ i) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 2][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 2][2]) % mod;
            dp[i][2] = (dp[i - 1][2] + dp[i - 2][2] + dp[i - 1][1] + dp[i - 1][0]) % mod;
        }
        return (int)dp[N][2];
    }

    public static void main(String[] args) {
        Solution790 m = new Solution790();
        System.out.println(m.numTilings(1000));
        System.out.println(m.numTilings(1));
    }
}
