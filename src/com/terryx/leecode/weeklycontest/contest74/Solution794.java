package com.terryx.leecode.weeklycontest.contest74;

import java.util.*;

/**
 * @author taoranxue on 3/3/18 9:31 PM.
 */
public class Solution794 {
    private static final int SIZE = 3;
    private int col[], row[];
    private int diag, antidiag;

    private int move(int r, int c, int player) {
        row[r] += (player == 1) ? 1 : -1;
        col[c] += (player == 1) ? 1 : -1;
        if (r == c) diag += (player == 1) ? 1 : -1;
        if (r + c == SIZE - 1) antidiag += (player == 1) ? 1 : -1;
        if (judge(row[r]) || judge(col[c]) || judge(antidiag) || judge(diag)) {
            return player;
        }
        return 0;
    }

    private boolean judge(int n) {
        return n == SIZE || n == -SIZE;
    }

    public boolean validTicTacToe(String[] board) {
        col = new int[SIZE];
        row = new int[SIZE];
        diag = 0;
        antidiag = 0;
        int a = 0, b = 0, r = 0;
        for (int i = 0; i < SIZE; ++i) {
            char s[] = board[i].toCharArray();
            for (int j = 0; j < SIZE; ++j) {
                if (s[j] == 'O') {
                    b++;
                    r = r == 0 ? move(i, j, 2) : r;
                } else if (s[j] == 'X') {
                    a++;
                    r = r == 0 ? move(i, j, 1) : r;
                }
//                System.out.println(i + " " + j + " " + r);
            }
        }
//        System.out.println(r);
        if (b > a || a > b + 1 ) return false;
        if (r == 1 && a != b + 1) {
            return false;
        }
        if (r == 2 && a != b) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution794 m = new Solution794();
        System.out.println(m.validTicTacToe(new String[]{"O  ", "   ", "   "}));
        System.out.println(m.validTicTacToe(new String[]{"XOX", " X ", "   "}));
        System.out.println(m.validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        System.out.println(m.validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
        System.out.println(m.validTicTacToe(new String[]{"XOX", "X O", "X O"}));
        System.out.println(m.validTicTacToe(new String[]{"XXX", "XOO", "OO "}));
        System.out.println(m.validTicTacToe(new String[]{"XOX", "OXO", "XXO"}));
    }
}
