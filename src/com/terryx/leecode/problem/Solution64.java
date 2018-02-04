package com.terryx.leecode.problem;

/**
 * @author taoranxue on 10/18/16 1:12 AM.
 */
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int a[][] = new int[m + 1][n + 1];
        a[0][0] = grid[0][0];
        for (int j = 1; j < n; ++j) {
            a[0][j] = grid[0][j] + a[0][j - 1];
        }
        for (int i = 1; i < m; ++i) {
            a[i][0] = grid[i][0] + a[i - 1][0];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                a[i][j] = grid[i][j] + Math.min(a[i - 1][j], a[i][j - 1]);
            }
        }
        return a[m - 1][n - 1];
    }
}
