package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 4:59 PM.
 */
public class Solution361 {

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int left[][] = new int[m][n];
        int right[][] = new int[m][n];
        int up[][] = new int[m][n];
        int down[][] = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 'E') {
                    left[i][j] = (j - 1 >= 0) ? 1 + left[i][j - 1] : 1;
                } else if (grid[i][j] == 'W') {
                    left[i][j] = 0;
                } else if (grid[i][j] == '0') {
                    left[i][j] = (j - 1 >= 0) ? left[i][j - 1] : 0;
                }
            }

            for (int j = n - 1; j >= 0; --j) {
                if (grid[i][j] == 'E') {
                    right[i][j] = (j + 1 < n) ? 1 + right[i][j + 1] : 1;
                } else if (grid[i][j] == 'W') {
                    right[i][j] = 0;
                } else if (grid[i][j] == '0') {
                    right[i][j] = (j + 1 < n) ? right[i][j + 1] : 0;
                }
            }
        }

        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < m; ++i) {
                if (grid[i][j] == 'E') {
                    up[i][j] = (i - 1 >= 0) ? up[i - 1][j] + 1 : 1;
                } else if (grid[i][j] == 'W') {
                    up[i][j] = 0;
                } else if (grid[i][j] == '0') {
                    up[i][j] = (i - 1 >= 0) ? up[i - 1][j] : 0;
                }
            }


            for (int i = m - 1; i >= 0; --i) {
                if (grid[i][j] == 'E') {
                    down[i][j] = (i + 1 < m) ? down[i + 1][j] + 1 : 1;
                } else if (grid[i][j] == 'W') {
                    down[i][j] = 0;
                } else if (grid[i][j] == '0') {
                    down[i][j] = (i + 1 < m) ? down[i + 1][j] : 0;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '0') {
                    res = Math.max(res, up[i][j] + down[i][j] + left[i][j] + right[i][j]);
                }
            }
        }
        return res;
    }
}
