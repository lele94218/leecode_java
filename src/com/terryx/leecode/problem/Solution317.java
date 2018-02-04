package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 3:31 PM.
 */
public class Solution317 {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int m = grid.length, n = grid[0].length;
        List<Integer> buildings = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    buildings.add(i * n + j);
                }
            }
        }

        int dist[][][] = new int[m][n][buildings.size()];
        int dx[] = new int[]{1, -1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        for (int i = 0; i < buildings.size(); ++i) {
            int code = buildings.get(i);
            boolean visited[] = new boolean[m * n];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(code);
            visited[code] = true;
            int level = 0, size = 0;
            while (!queue.isEmpty()) {
                size = queue.size();
                for (int j = 0; j < size; ++j) {
                    code = queue.poll();
                    int x = code / n, y = code % n;
                    dist[x][y][i] = level;
                    for (int k = 0; k < 4; ++k) {
                        int nx = x + dx[k], ny = y + dy[k], nCode = nx * n + ny;
                        if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && !visited[nCode]) {
                            queue.offer(nCode);
                            visited[nCode] = true;
                        }
                    }
                }
                level++;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    boolean flag = true;
                    int sum = 0;
                    for (int k = 0; k < buildings.size(); ++k) {
                        sum += dist[i][j][k];
                        if (dist[i][j][k] == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        res = Math.min(res, sum);
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
