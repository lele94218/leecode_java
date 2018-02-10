package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/9/18 5:11 PM.
 */
public class Solution407 {
    static class Pair {
        int code, height;

        Pair(int code, int height) {
            this.code = code;
            this.height = height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return a.height - b.height;
            }
        });
        int m = heightMap.length, n = heightMap[0].length;
        boolean visited[] = new boolean[m * n];
        for (int i = 0; i < m; ++i) {
            queue.offer(new Pair(i * n, heightMap[i][0]));
            visited[i * n] = true;
            queue.offer(new Pair(i * n + n - 1, heightMap[i][n - 1]));
            visited[i * n + n - 1] = true;
        }
        for (int j = 1; j < n - 1; ++j) {
            queue.offer(new Pair(j, heightMap[0][j]));
            visited[j] = true;
            queue.offer(new Pair((m - 1) * n + j, heightMap[m - 1][j]));
            visited[(m - 1) * n + j] = true;
        }

        int res = 0;
        int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int x = cur.code / n, y = cur.code % n;
            for (int k = 0; k < 4; ++k) {
                int nx = x + dx[k], ny = y + dy[k], ncode = nx * n + ny;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ncode]) {
                    visited[ncode] = true;
                    res += Math.max(0, cur.height - heightMap[nx][ny]);
                    queue.offer(new Pair(ncode, Math.max(cur.height, heightMap[nx][ny])));
                }
            }
        }
        return res;
    }
}
