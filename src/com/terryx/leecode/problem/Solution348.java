package com.terryx.leecode.problem;

/**
 * @author taoranxue on 10/30/16 2:42 AM.
 */
public class Solution348 {
    public class TicTacToe {
        int n;
        int col[];
        int row[];
        int diagonal;
        int antiDiagonal;

        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            this.n = n;
            col = new int[n + 1];
            row = new int[n + 1];
            diagonal = 0;
            antiDiagonal = 0;
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            this.row[row] += (player == 1) ? 1 : -1;
            this.col[col] += (player == 1) ? 1 : -1;
            if (row == col)
                diagonal += (player == 1) ? 1 : -1;
            if (row + col == n - 1)
                antiDiagonal += (player == 1) ? 1 : -1;
            if (judge(this.row[row]) || judge(this.col[col]) || judge(this.diagonal) || judge(this.antiDiagonal)) {
                return player;
            }
            return 0;
        }

        boolean judge(int num) {
            return (num == n || num == -n);
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
