package com.terryx.leecode;

/**
 * @author taoranxue on 10/18/16 1:02 AM.
 */
public class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int a[][] = new int[m + 1][n + 1];
        for (int j = 1; j <= n; ++j) {
            if (obstacleGrid[0][j - 1] == 1) a[1][j] = 0;
            else {
                if (j == 1) a[1][j] = 1;
                else a[1][j] = a[1][j - 1];
            }
        }
        for (int i = 1; i <= m; ++i) {
            if (obstacleGrid[i - 1][0] == 1) a[i][1] = 0;
            else {
                if (i == 1) a[i][1] = 1;
                else a[i][1] = a[i - 1][1];
            }
        }
        for (int i = 2; i <= m; ++i) {
            for (int j = 2; j <= n; ++j) {
                if (obstacleGrid[i - 1][j - 1] == 1) a[i][j] = 0;
                else a[i][j] = a[i - 1][j] + a[i][j - 1];
            }
        }
        return a[m][n];
    }
}
