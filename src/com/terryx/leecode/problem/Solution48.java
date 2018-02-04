package com.terryx.leecode.problem;

/**
 * @author taoranxue on 8/29/16 3:22 PM.
 */
public class Solution48 {
    public void rotate(int[][] matrix) {
        int n = matrix[0].length;
        // up is down
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - i - 1][j];
                matrix[n - i - 1][j] = tmp;
            }
        }

        // dui jiao xian

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j)
                if (i != j) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
        }
    }
}
