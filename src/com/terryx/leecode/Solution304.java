package com.terryx.leecode;

/**
 * @author taoranxue on 10/20/16 11:50 PM.
 */
public class Solution304 {
    public class NumMatrix {
        int d[][];

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) {
                d = new int[0][0];
                return;
            }
            int n = matrix[0].length;
            d = new int[m + 1][n + 1];
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    d[i][j] = d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1] + matrix[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return d[row2 + 1][col2 + 1] - d[row2 + 1][col1] - d[row1][col2 + 1] + d[row1][col1];
        }
    }

    public static void main(String args[]) {
        int a[][] = new int[3][3];
        int cnt = 1;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                a[i][j] = cnt++;
            }
        }
        Solution304 solution304 = new Solution304();
        NumMatrix n = solution304.new NumMatrix(a);
        for (int i = 0; i <= 3; ++i) {
            for (int j = 0; j <= 3; ++j) {
                System.out.print(n.d[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(n.sumRegion(0,0,1,2));
    }


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
}
