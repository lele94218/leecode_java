package com.terryx.leecode.problem;

/**
 * @author taoranxue on 8/3/17 10:30 PM.
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        boolean col0 = false;
        for (int i = 0; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) col0 = true;
            for (int j = 1; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; --i) {
            for (int j = matrix[i].length - 1; j >= 1; --j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0) {
                matrix[i][0] = 0;
            }
        }
    }
}
