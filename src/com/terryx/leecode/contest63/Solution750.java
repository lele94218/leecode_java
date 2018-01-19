package com.terryx.leecode.contest63;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 8:05 PM.
 */
public class Solution750 {
    public int countCornerRectangles(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = i + 1; j < m; ++j) {
                int cnt = 0;
                for (int k = 0; k < n; ++k) {
                    if (grid[i][k] + grid[j][k] == 2) {
                        cnt++;
                    }
                }
                res += (cnt * (cnt - 1)) / 2;
            }
        }
        return res;
    }

}
