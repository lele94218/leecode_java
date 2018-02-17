package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/17/18 1:03 PM.
 */
public class Solution711 {

    public int numDistinctIslands2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean visit[] = new boolean[m * n];
        Set<String> count = new HashSet<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int code = i * n + j;
                if (grid[i][j] == 1 && !visit[code]) {
                    Set<Integer> set = new HashSet<>();
                    visit[code] = true;
                    dfs(code, grid, visit, set, m, n);
                    int xs[] = new int[set.size()], ys[] = new int[set.size()];
                    String save = "";
                    for (int c = 0; c < 8; ++c) {
                        int t = 0;
                        for (Integer ncode : set) {
                            int x = ncode / n, y = ncode % n;
                            xs[t] = c <= 1 ? x : c <= 3 ? -x : c <= 5 ? y : -y;
                            ys[t++] = c <= 3 ? (c % 2 == 0 ? y : -y) : (c % 2 == 0 ? x : -x);
                        }
                        int mx = xs[0], my = ys[0];
                        for (int x : xs) mx = Math.min(mx, x);
                        for (int y : ys) my = Math.min(my, y);
                        Set<Integer> tmp = new TreeSet<>();
                        for (int k = 0; k < set.size(); ++k) {
                            tmp.add((xs[k] - mx) * (m + n) + ys[k] - my);
                        }
                        String candidate = tmp.toString();
//                        System.out.println("-> " + candidate);
                        if (save.compareTo(candidate) < 0) save = candidate;
                    }
                    count.add(save);
//                    System.out.println("finish");

                }
            }
        }
        for (Object set : count) {
            System.out.println(set);
        }
        return count.size();
    }


    int dx[] = new int[]{-1, 1, 0, 0}, dy[] = new int[]{0, 0, -1, 1};

    private void dfs(int code, int[][] grid, boolean visit[], Set<Integer> set, int m, int n) {
        int x = code / n, y = code % n;
        set.add(code);
        for (int k = 0; k < 4; ++k) {
            int nx = x + dx[k], ny = y + dy[k], ncode = nx * n + ny;
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1 && !visit[ncode]) {
                visit[ncode] = true;
                dfs(ncode, grid, visit, set, m, n);
            }
        }
    }

    public static void main(String[] args) {
        Solution711 m = new Solution711();
//        System.out.println(m.numDistinctIslands2(
//                new int[][]{{1, 1, 0, 0, 0}, {1, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 1, 1}})
//        );


        System.out.println(m.numDistinctIslands2(
                new int[][]{{0, 1, 1}, {1, 1, 1}, {0, 0, 0}, {1, 1, 1}, {1, 1, 0}})
        );
    }
}
