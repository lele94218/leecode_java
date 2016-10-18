package com.terryx.leecode;

/**
 * @author taoranxue on 10/18/16 12:53 AM.
 */
public class Solution62 {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[][] a = new int[m + 1][n + 1];
        for (int j = 1; j <= n; ++ j) {
            a[1][j] = 1;
        }
        for (int i = 1; i <= m; ++ i) {
            a[i][1] = 1;
        }
        for (int i = 2; i <= m; ++ i) {
            for (int j = 2; j <= n; ++ j) {
                a[i][j] = a[i-1][j] + a[i][j-1];
            }
        }
        return a[m][n];
    }
}
