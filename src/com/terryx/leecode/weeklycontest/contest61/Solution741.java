package com.terryx.leecode.weeklycontest.contest61;

/**
 * @author taoranxue on 1/23/18 4:28 PM.
 */
public class Solution741 {

    public int cherryPickup(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int N = grid.length;
        int dp[][][] = new int[N][N][N];
        dp[0][0][0] = grid[0][0];

        for (int len = 1; len < N * 2 - 1; ++len) {
            for (int y1 = N - 1; y1 >= 0; --y1) {
                for (int y2 = N - 1; y2 >= 0; --y2) {
                    int x1 = len - y1, x2 = len - y2;
                    if (x1 < 0 || x1 >= N || x2 < 0 || x2 >= N) {
                        continue;
                    }
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        dp[x1][y1][x2] = -1;
                        continue;
                    }
                    int delta = grid[x1][y1];
                    if (y1 != y2) {
                        delta += grid[x2][y2];
                    }
                    int res = -1;
                    //ll
                    if (y1 - 1 >= 0 && y2 - 1 >= 0 && dp[x1][y1 - 1][x2] >= 0)
                        res = Math.max(res, dp[x1][y1 - 1][x2] + delta);
                    //uu
                    if (x1 - 1 >= 0 && x2 - 1 >= 0 && dp[x1 - 1][y1][x2 - 1] >= 0)
                        res = Math.max(res, dp[x1 - 1][y1][x2 - 1] + delta);
                    //lu
                    if (y1 - 1 >= 0 && x2 - 1 >= 0 && dp[x1][y1 - 1][x2 - 1] >= 0)
                        res = Math.max(res, dp[x1][y1 - 1][x2 - 1] + delta);
                    //ul
                    if (x1 - 1 >= 0 && y2 - 1 >= 0 && dp[x1 - 1][y1][x2] >= 0)
                        res = Math.max(res, dp[x1 - 1][y1][x2] + delta);

                    dp[x1][y1][x2] = res;
                }
            }
        }
        return Math.max(dp[N - 1][N - 1][N - 1], 0);
    }

}
