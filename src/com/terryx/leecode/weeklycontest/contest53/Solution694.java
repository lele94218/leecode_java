package com.terryx.leecode.weeklycontest.contest53;

import java.util.*;

/**
 * @author taoranxue on 2/15/18 2:38 PM.
 */
public class Solution694 {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Point)) {
                return false;
            }
            Point p = (Point) obj;
            return p.x == this.x && p.y == this.y;
        }

        @Override
        public int hashCode() {
            return (x << 16) + y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean visit[] = new boolean[m * n];
        Set<Set<Point>> count = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int code = i * n + j;
                if (grid[i][j] == 1 && !visit[code]) {
                    Set<Point> set = new HashSet<>();
                    visit[code] = true;
                    dfs(code, grid, visit, set, m, n, new Point(i, j));
                    count.add(set);
                }
            }
        }
//        for (Set<Point> set : count) {
//            System.out.println(set);
//        }
        return count.size();
    }


    int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};

    private void dfs(int code, int[][] grid, boolean visit[], Set<Point> set, int m, int n, Point start) {
        int x = code / n, y = code % n;
        set.add(new Point(x - start.x, y - start.y));
        for (int k = 0; k < 4; ++k) {
            int nx = x + dx[k], ny = y + dy[k], ncode = nx * n + ny;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1 && !visit[ncode]) {
                visit[ncode] = true;
                dfs(ncode, grid, visit, set, m, n, start);
            }
        }
    }

    public static void main(String[] args) {
        Solution694 m = new Solution694();
        System.out.println(m.numDistinctIslands(
                new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}}
        ));
        System.out.println(m.numDistinctIslands(
                new int[][]{{1, 1, 0, 1, 1}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {1, 1, 0, 1, 1}}
        ));
        System.out.println(m.numDistinctIslands(
                new int[][]{{1, 1, 1, 1}, {1, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 1, 1}, {1, 1, 0, 1}}
        ));
    }
}
