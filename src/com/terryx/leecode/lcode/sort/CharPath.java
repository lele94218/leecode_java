package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/26/17 4:32 PM.
 */
public class CharPath {
    public static int dx[] = new int[]{1, 0}, dy[] = new int[]{0, 1};

    public static List<String> charPath(char[][] map) {
        if (map == null) return new ArrayList<>(0);
        int m = map.length, n = map[0].length;
        List<String> ans = new ArrayList<>();
        dfs(0, 0, m, n, map, ans, new char[m + n - 1], 0);
        return ans;
    }


    private static void dfs(int x, int y, int m, int n, char[][] map, List<String> ans, char[] path, int idx) {
        path[idx] = map[x][y];
        if (x == m - 1 && y == n - 1) {
            ans.add(new String(path));
            return;
        }
        for (int i = 0; i < dx.length; ++i) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                dfs(nx, ny, m, n, map, ans, path, idx + 1);
            }
        }
    }

    public static void main(String[] args) {
        char map[][] = new char[][]{
                new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'},
                new char[]{'a', 'b', 'c'},
                new char[]{'d', 'e', 'f'}
        };
        List<String> ans = charPath(map);
        System.out.println(ans);
    }
}
