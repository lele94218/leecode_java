package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/27/18 6:01 PM.
 */
public class Solution308 {
    class NumMatrix {
        int matrix[][], tree[][];
        int m, n;

        public NumMatrix(int[][] matrix) {
            m = matrix.length;
            n = 0;
            if (m > 0) {
                n = matrix[0].length;
            }
            this.matrix = matrix;
            tree = new int[m + 1][n + 1];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    add(i + 1, j + 1, matrix[i][j]);
                }
            }
        }

        private void add(int r, int c, int val) {
            for (int i = r; i <= m; i += (i & -i)) {
                for (int j = c; j <= n; j += (j & -j)) {
                    tree[i][j] += val;
                }
            }
        }

        private int sum(int r, int c) {
            int sum = 0;
            for (int i = r; i > 0; i -= (i & -i)) {
                for (int j = c; j > 0; j -= (j & -j)) {
                    sum += tree[i][j];
                }
            }
            return sum;
        }

        public void update(int row, int col, int val) {
            int diff = val - matrix[row][col];
            matrix[row][col] = val;
            add(row + 1, col + 1, diff);
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum1 = sum(row2 + 1, col2 + 1);
            int sum2 = sum(row2 + 1, col1);
            int sum3 = sum(row1, col2 + 1);
            int sum4 = sum(row1, col1);
            return sum1 - sum2 - sum3 + sum4;
        }
    }


}
