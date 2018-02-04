package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author taoranxue on 8/4/17 5:31 PM.
 */
public class Solution79 {
    final static int[] dx = new int[]{1, -1, 0, 0};
    final static int[] dy = new int[]{0, 0, -1, 1};

    char[][] board = null;
    boolean[][] vis = null;

    boolean dfs(int x, int y, int idx, String word) {
        if (board[x][y] != word.charAt(idx)) return false;

        if (idx + 1 == word.length()) return true;
        HashSet set = new HashSet();
        set.add("fds");
        vis[x][y] = true;
        for (int i = 0; i < dx.length; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
                    && !vis[nx][ny]) {
                vis[nx][ny] = true;
                if (dfs(nx, ny, idx + 1, word)) {
                    return true;
                }
                vis[nx][ny] = false;
            }
        }

        vis[x][y] = false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        if (word == null || word.length() == 0) return true;

        int height = board.length;
        int width = board[0].length;
        this.board = board;
        this.vis = new boolean[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {

                if (dfs(i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
}
