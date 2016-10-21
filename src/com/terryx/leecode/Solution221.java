package com.terryx.leecode;

/**
 * @author taoranxue on 10/20/16 8:30 PM.
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int d[][] = new int[m + 1][n + 1];
        int res = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (matrix[i - 1][j - 1] == '1') {
                    d[i][j] = Math.min(Math.min(d[i-1][j], d[i][j-1]), d[i-1][j-1]) + 1;
                    res = Math.max(d[i][j], res);
                }
            }
        }
        return res * res;
    }
}
