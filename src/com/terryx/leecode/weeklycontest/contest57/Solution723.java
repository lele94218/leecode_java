package com.terryx.leecode.weeklycontest.contest57;

import java.util.*;

/**
 * @author taoranxue on 2/5/18 5:16 PM.
 */
public class Solution723 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean con = true;
        while (con) {
            boolean flag = false;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n - 2; ++j) {
                    int v = Math.abs(board[i][j]);
                    if (v != 0 && Math.abs(board[i][j + 1]) == v && Math.abs(board[i][j + 2]) == v) {
                        flag = true;
                        board[i][j] = board[i][j + 1] = board[i][j + 2] = -v;
                    }
                }
            }

            for (int j = 0; j < n; ++j) {
                for (int i = 0; i < m - 2; ++i) {
                    int v = Math.abs(board[i][j]);
                    if (v != 0 && Math.abs(board[i + 1][j]) == v && Math.abs(board[i + 2][j]) == v) {
                        flag = true;
                        board[i][j] = board[i + 1][j] = board[i + 2][j] = -v;
                    }
                }
            }

            for (int j = 0; j < n; ++ j) {
                int index = m - 1;
                for (int i = m - 1; i >= 0; -- i) {
                    if (board[i][j] > 0) {
                        board[index--][j] = board[i][j];
                    }
                }
                while (index >= 0) {
                    board[index--][j] = 0;
                }
            }
            con = flag;
        }
        return board;
    }
}
