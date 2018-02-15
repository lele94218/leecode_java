package com.terryx.leecode.weeklycontest.contest53;

import java.util.*;

/**
 * @author taoranxue on 2/15/18 2:27 PM.
 */
public class Solution695 {
    int res = 0, cur = 0;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean visit[] = new boolean[m * n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int code = i * n + j;
                if (grid[i][j] == 1 && !visit[code]) {
                    cur = 0;
                    visit[code] = true;
                    dfs(code, grid, visit, m, n);
                    res = Math.max(res, cur);
                }
            }
        }
        return res;
    }

    int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};

    private void dfs(int code, int[][] grid, boolean visit[], int m, int n) {
        cur++;
        int x = code / n, y = code % n;
        for (int k = 0; k < 4; ++k) {
            int nx = x + dx[k], ny = y + dy[k], ncode = nx * n + ny;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1 && !visit[ncode]) {
                visit[ncode] = true;
                dfs(ncode, grid, visit, m, n);
            }
        }
    }
}
