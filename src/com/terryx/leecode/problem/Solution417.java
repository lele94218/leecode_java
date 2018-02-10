package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/7/18 8:12 PM.
 */
public class Solution417 {

    static int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        //Map: 00 no where, 01 pacific, 10 atlantic, 11 both;
        int[][] visited = new int[m][n];
        for (int i = 0; i < m; ++i) {
            visited[i][0] |= 1;
            dfs(i * n, matrix, m, n, 0, matrix[i][0], visited);
            visited[i][n - 1] |= 2;
            dfs(i * n + n - 1, matrix, m, n, 1, matrix[i][n - 1], visited);
        }

        for (int j = 0; j < n; ++j) {
            visited[0][j] |= 1;
            dfs(j, matrix, m, n, 0, matrix[0][j], visited);
            visited[m - 1][j] |= 2;
            dfs((m - 1) * n + j, matrix, m, n, 1, matrix[m - 1][j], visited);
        }

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                // System.out.print(visited[i][j] + " ");
                if (visited[i][j] == 3) {
                    res.add(new int[]{i, j});
                }
            }
            // System.out.println();
        }

        return res;
    }

    private void dfs(int code, int[][] matrix, int m, int n, int bit, int height, int visited[][]) {
        int x = code / n, y = code % n;
        for (int k = 0; k < 4; ++k) {
            int nx = x + dx[k], ny = y + dy[k];
            int ncode = nx * n + ny;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && height <= matrix[nx][ny] && (visited[nx][ny] & (1 << bit)) == 0) {
                visited[nx][ny] |= (1 << bit);
                dfs(ncode, matrix, m, n, bit, matrix[nx][ny], visited);
            }
        }
    }
}
