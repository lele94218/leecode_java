package com.terryx.leecode.weeklycontest.contest63;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 8:36 PM.
 */
public class Solution749 {

    private static int dx[] = new int[]{0, 0, -1, 1};
    private static int dy[] = new int[]{1, -1, 0, 0};

    public int containVirus(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, res = 0;
        while (true) {
            List<Set<Integer>> regions = new ArrayList<>();
            List<List<Integer>> boundaries = new ArrayList<>();
            List<Integer> walls = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    int code = i * n + j;
                    if (grid[i][j] == 1 && !visited.contains(code)) {
                        regions.add(new HashSet<>());
                        boundaries.add(new ArrayList<>());
                        int last = regions.size() - 1;
                        dfs(grid, i, j, m, n, visited, regions.get(last), boundaries.get(last));
                    }
                }
            }

            if (regions.size() == 0) {
                break;
            }

            int maxIndex = 0, maxCells = 0;
            for (int i = 0; i < boundaries.size(); ++i) {
                Set<Integer> set = new HashSet<>(boundaries.get(i));
                if (set.size() > maxCells) {
                    maxCells = set.size();
                    maxIndex = i;
                }
            }


            res += boundaries.get(maxIndex).size();
            //
            for (Integer code : regions.get(maxIndex)) {
                int x = code / n, y = code % n;
                grid[x][y] = -1;
            }
            //

            for (int i = 0; i < boundaries.size(); ++i) {
                if (i != maxIndex) {
                    for (Integer code : boundaries.get(i)) {
                        int x = code / n, y = code % n;
                        if (grid[x][y] == 0) {
                            grid[x][y] = 1;
                        }
                    }
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int x, int y, int m, int n, Set<Integer> visited, Set<Integer> region, List<Integer> boundary) {
        int code = x * n + y;
        if (!visited.contains(code)) {
            if (grid[x][y] == 1) {
                visited.add(code);
                region.add(code);
                for (int i = 0; i < 4; ++i) {
                    int nx = x + dx[i], ny = y + dy[i];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        dfs(grid, nx, ny, m, n, visited, region, boundary);
                    }
                }
            } else if (grid[x][y] == 0) {
                boundary.add(code);
            }
        }
    }
}
