package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/26/18 7:17 PM.
 */
public class Solution490 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[m * n];
        int stop[][] = new int[4][m * n];
        // to up
        for (int y = 0; y < n; ++y) {
            int tmp = y;
            for (int x = 0; x < m; ++x) {
                int code = x * n + y;
                if (maze[x][y] == 0) {
                    stop[0][code] = tmp;
                } else {
                    tmp = (x + 1) * n + y;
                }
            }
        }
        // to down
        for (int y = 0; y < n; ++y) {
            int tmp = (m - 1) * n + y;
            for (int x = m - 1; x >= 0; --x) {
                int code = x * n + y;
                if (maze[x][y] == 0) {
                    stop[1][code] = tmp;
                } else {
                    tmp = (x - 1) * n + y;
                }
            }
        }
        // to left
        for (int x = 0; x < m; ++x) {
            int tmp = x * n;
            for (int y = 0; y < n; ++y) {
                int code = x * n + y;
                if (maze[x][y] == 0) {
                    stop[2][code] = tmp;
                } else {
                    tmp = x * n + y + 1;
                }
            }
        }
        // to right
        for (int x = 0; x < m; ++x) {
            int tmp = x * n + n - 1;
            for (int y = n - 1; y >= 0; --y) {
                int code = x * n + y;
                if (maze[x][y] == 0) {
                    stop[3][code] = tmp;
                } else {
                    tmp = x * n + y - 1;
                }
            }
        }
        int code = start[0] * n + start[1];
        queue.offer(code);
        visited[code] = true;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / n, y = cur % n;
            if (x == destination[0] && y == destination[1]) {
                return true;
            }
            for (int k = 0; k < 4; ++k) {
                int ncode = stop[k][cur];
                int nx = ncode / n, ny = ncode % n;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && maze[nx][ny] == 0 && !visited[ncode]) {
                    queue.offer(ncode);
                    visited[ncode] = true;
                }
            }
        }
        return false;
    }
}
