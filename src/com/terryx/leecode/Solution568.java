package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/19/18 6:41 PM.
 */
public class Solution568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        if (flights == null || days == null) {
            return 0;
        }
        int N = flights.length, K = days[0].length;
        int dp[][] = new int[N][2];
        for (int j = K - 1; j >= 0; --j) {
            for (int i = 0; i < N; ++i) {
                for (int k = 0; k < N; ++k) {
                    if (flights[i][k] == 1 || i == k) {
                        dp[i][j & 1] = Math.max(dp[i][j & 1], dp[k][(j + 1) & 1] + days[k][j]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
