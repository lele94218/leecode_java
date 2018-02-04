package com.terryx.leecode.weeklycontest.contest70;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 10:44 PM.
 */
public class Solution778 {
    static class Pair {
        int code, val, time;

        Pair(int code, int val, int time) {
            this.code = code;
            this.val = val;
            this.time = time;
        }
    }

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.val - b.val;
            }
        });
        Set<Integer> set = new HashSet<>();
        queue.offer(new Pair(0, grid[0][0], grid[0][0]));
        set.add(0);
        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int code = cur.code;
            int x = code / n, y = code % n;
            int t = cur.time;
            System.out.println(x + " " + y + ": " + t);
            if (x == m - 1 && y == n - 1) {
                return t;
            }
            for (int k = 0; k < 4; ++k) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !set.contains(nx * n + ny)) {
                    int ncode = nx * n + ny;
                    set.add(ncode);
                    queue.offer(new Pair(ncode, grid[nx][ny] - t,
                            t + (grid[nx][ny] - t < 0 ? 0 : grid[nx][ny] - grid[x][y])));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution778 m = new Solution778();
        System.out.println(m.swimInWater(new int[][]{{0, 2}, {1, 3}}));
        System.out.println(m.swimInWater(new int[][]{{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},
                {11,17,18,19,20},{10,9,8,7,6}}));
        System.out.println(m.swimInWater(new int[][]{{3,2},{0,1}}));
    }
}
