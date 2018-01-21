package com.terryx.leecode.contest68;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 9:31 PM.
 */
public class Solution766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return true;
        }
        int m = matrix.length, n = matrix[0].length;
        for (int j = 0; j < n; ++ j) {
            int x = 0, y = j, t = matrix[x][y];
            for (; x < m && y < n; ++ x, ++ y) {
                if (matrix[x][y] != t) {
                    return false;
                }
            }
        }

        for (int i = 0; i < m; ++ i) {
            int x = i, y = 0, t = matrix[x][y];
            for(; x < m && y < n; ++ x, ++ y) {
                if (matrix[x][y] != t) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution766 m = new Solution766();
        System.out.println(m.isToeplitzMatrix(new int[][]{{1, 2}, {2, 2}}));
        System.out.println(m.isToeplitzMatrix(new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}}));
    }
}
