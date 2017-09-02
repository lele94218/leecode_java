package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 2:37 PM.
 */
public class Solution576 {
    public int findPaths(int m, int n, int N, int sx, int sy) {
        int dp[][] = new int[m][n], prev[][] = new int[m][n];
        int dx[] = new int[]{1, -1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        int mod = 1000000007;
        for (int t = 1; t <= N; ++t) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int x = i, y = j;
                    for (int k = 0; k < dx.length; ++k) {
                        int nx = x + dx[k], ny = y + dy[k];
                        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                            dp[i][j] = (dp[i][j] + 1) % mod;
                        } else {
                            dp[i][j] = (dp[i][j] + prev[nx][ny]) % mod;
                        }
                    }
                }
            }

            // swap
            int tmp[][] = dp;
            dp = prev;
            prev = tmp;

            for (int i = 0; i < m; ++i)
                Arrays.fill(dp[i], 0);
        }
        return prev[sx][sy];
    }
}
