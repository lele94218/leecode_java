package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/31/18 6:25 PM.
 */
public class Solution329 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        int m = matrix.length, n = matrix[0].length;
        int dp[][] = new int[m][n], degree[][] = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int code = i * n + j;
                for (int k = 0; k < 4; ++k) {
                    int nx = i + dx[k], ny = j + dy[k];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] < matrix[i][j]) {
                        degree[nx][ny]++;
                    }
                }
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (degree[i][j] == 0) {
                    queue.offer(i * n + j);
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int from = queue.poll();
            int x = from / n, y = from % n;
            for (int k = 0; k < 4; ++k) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx][ny] < matrix[x][y]) {
                    dp[nx][ny] = Math.max(dp[nx][ny], dp[x][y] + 1);
                    res = Math.max(res, dp[nx][ny]);
                    if (--degree[nx][ny] == 0) {
                        queue.offer(nx * n + ny);
                    }
                }
            }

        }
        return res + 1;
    }
}
