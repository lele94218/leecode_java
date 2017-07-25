package com.terryx.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 7/25/17 5:08 PM.
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new ArrayList<Integer>(0);
        int direction = 0;
        int height = matrix.length;
        int width = matrix[0].length;
        boolean vis[][] = new boolean[height][width];
        int i = 0, j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        res.add(matrix[0][0]);
        vis[0][0] = true;
        while (true) {
            if (vis[Math.min(i + 1, height - 1)][j] && vis[Math.max(i - 1, 0)][j] && vis[i][Math.max(j - 1, 0)] && vis[i][Math.min(j + 1, width - 1)]) {
                break;
            }
            switch(direction) {
                case 0:
                    if (j + 1 >= width || vis[i][j + 1]) {
                        direction = 1;
                    } else {
                        j = j + 1;
                        vis[i][j] = true;
                        res.add(matrix[i][j]);
                        break;
                    }
                case 1:
                    if (i + 1 >= height || vis[i + 1][j]) {
                        direction = 2;
                    } else {
                        i = i + 1;
                        vis[i][j] = true;
                        res.add(matrix[i][j]);
                        break;
                    }
                case 2:
                    if (j - 1 < 0 || vis[i][j - 1]) {
                        direction = 3;
                    } else {
                        j = j - 1;
                        vis[i][j] = true;
                        res.add(matrix[i][j]);
                        break;
                    }
                case 3:
                    if (i - 1 < 0 || vis[i - 1][j]) {
                        direction = 0;
                    } else {
                        i = i - 1;
                        vis[i][j] = true;
                        res.add(matrix[i][j]);
                        break;
                    }
            }
        }

        return res;
    }
}
