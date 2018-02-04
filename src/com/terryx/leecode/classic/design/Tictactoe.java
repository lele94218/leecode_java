package com.terryx.leecode.classic.design;

import java.util.*;

/**
 * @author taoranxue on 9/24/17 11:45 PM.
 */
public class Tictactoe {
    private static final int SIZE = 3;
    private int col[], row[];
    private char[][] board;
    private int diag, antidiag;

    public Tictactoe() {
        board = new char[SIZE][SIZE];
        col = new int[SIZE];
        row = new int[SIZE];
        diag = 0;
        antidiag = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                board[i][j] = '-';
            }
        }

    }

    private void showBoard() {
        System.out.println();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[i].length; ++j) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int move(int r, int c, int player) {
        if (!isLegal(r, c) || board[r][c] != '-') return -1;
        row[r] += (player == 1) ? 1 : -1;
        col[c] += (player == 1) ? 1 : -1;
        if (r == c) diag += (player == 1) ? 1 : -1;
        if (r + c == SIZE - 1) antidiag += (player == 1) ? 1 : -1;
        if (player == 1) board[r][c] = 'O';
        if (player == 2) board[r][c] = 'X';
        if (judge(row[r]) || judge(col[c]) || judge(antidiag) || judge(diag)) {
            return player;
        }
        return 0;
    }

    private boolean judge(int n) {
        return n == SIZE || n == -SIZE;
    }

    private boolean isLegal(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }

    public void play() {
        Scanner in = new Scanner(System.in);
        int player = 1, cnt = 0;
        while (true) {
            showBoard();
            int r = in.nextInt(), l = in.nextInt();
            int win = move(r - 1, l - 1, player);
            if (win == -1) {
                System.out.println("Error move!");
                continue;
            }
            if (win != 0) {
                showBoard();
                System.out.println("Player " + win + " win!");
                break;
            }
            player = (player == 1) ? 2 : 1;
            cnt ++;
            if (cnt == SIZE * SIZE) {
                showBoard();
                System.out.println("Draw");
                break;
            }
        }
    }
}
