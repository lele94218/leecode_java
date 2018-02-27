package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/26/18 8:01 PM.
 */
public class Solution505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
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

        int dist[] = new int[m * n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return dist[a] - dist[b];
            }
        });

        int code = start[0] * n + start[1];
        dist[code] = 0;
        queue.offer(code);


        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / n, y = cur % n;
            for (int k = 0; k < 4; ++k) {
                int ncode = stop[k][cur];
                int nx = ncode / n, ny = ncode % n;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && maze[nx][ny] == 0) {
                    int len = dist[cur] + Math.abs(nx - x) + Math.abs(ny - y);
                    if (dist[ncode] <= len) continue;
                    dist[ncode] = len;
                    queue.offer(ncode);
                }
            }
        }
        int dst = destination[0] * n + destination[1];
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
