package com.terryx.leecode.weeklycontest.contest70;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 10:44 PM.
 */
public class Solution778 {

    public int swimInWater(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return grid[a / n][a % n] - grid[b / n][b % n];
            }
        });
        Set<Integer> set = new HashSet<>();
        set.add(0);
        queue.offer(0);
        int res = 0;
        while (!queue.isEmpty()) {
            int code = queue.poll();
            int x = code / n, y = code % n;
            res = Math.max(res, grid[x][y]);
            if (x == m - 1 && y == n - 1) {
                return res;
            }
            for (int k = 0; k < 4; ++ k) {
                int nx = x + dx[k], ny = y + dy[k], ncode = nx * n + ny;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !set.contains(ncode)) {
                    queue.offer(ncode);
                    set.add(ncode);
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
