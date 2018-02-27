package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/26/18 8:20 PM.
 */
public class Solution499 {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        int stop[][] = new int[4][m * n];
        // to up
        for (int y = 0; y < n; ++y) {
            int tmp = y;
            for (int x = 0; x < m; ++x) {
                int code = x * n + y;
                if (x == hole[0] && y == hole[1]) {
                    tmp = x * n + y;
                } else if (maze[x][y] == 0) {
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
                if (x == hole[0] && y == hole[1]) {
                    tmp = x * n + y;
                } else if (maze[x][y] == 0) {
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
                if (x == hole[0] && y == hole[1]) {
                    tmp = x * n + y;
                } else if (maze[x][y] == 0) {
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
                if (x == hole[0] && y == hole[1]) {
                    tmp = x * n + y;
                } else if (maze[x][y] == 0) {
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

        int code = ball[0] * n + ball[1];
        dist[code] = 0;
        queue.offer(code);
        String path[] = new String[m * n];
        path[code] = "";

        char[] dict = new char[]{'u', 'd', 'l', 'r'};
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int x = cur / n, y = cur % n;
            for (int k = 0; k < 4; ++k) {
                int ncode = stop[k][cur];
                int nx = ncode / n, ny = ncode % n;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n
                        && maze[nx][ny] == 0) {
                    int len = dist[cur] + Math.abs(nx - x) + Math.abs(ny - y);
                    String nPath = path[cur] + dict[k];
                    if (dist[ncode] < len || (dist[ncode] == len && path[ncode].compareTo(nPath) <= 0)) continue;
                    dist[ncode] = len;
                    path[ncode] = nPath;
                    queue.offer(ncode);
                }
            }
        }
        int dst = hole[0] * n + hole[1];
        return path[dst] == null ? "impossible" : path[dst];
    }
}
