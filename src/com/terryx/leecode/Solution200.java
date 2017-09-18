package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/18/17 1:56 PM.
 */
public class Solution200 {
    int dx[] = new int[]{0, 0, -1, 1};
    int dy[] = new int[]{1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int res = 0;
        int m = grid.length, n = grid[0].length;
        boolean vist[][] = new boolean[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == '1' && !vist[i][j]) {
                    res++;
                    dfs(grid, vist, i, j, m, n);
                }
        }
        return res;

    }

    private void dfs(char[][] grid, boolean[][] vist, int x, int y, int m, int n) {
        if (grid[x][y] == '0' || vist[x][y]) return;
        vist[x][y] = true;
        for (int i = 0; i < dx.length; ++i) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n)
                dfs(grid, vist, nx, ny, m, n);
        }
    }
}
