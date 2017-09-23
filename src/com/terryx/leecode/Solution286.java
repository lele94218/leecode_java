package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/23/17 3:24 PM.
 */
public class Solution286 {
    private final int dx[] = new int[]{0, 0, -1, 1};
    private final int dy[] = new int[]{1, -1, 0, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j)
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && rooms[nx][ny] == Integer.MAX_VALUE) {
                    rooms[nx][ny] = rooms[x][y] + 1;
                    queue.offer(new int[]{nx, ny});

                }
            }
        }
    }
}
