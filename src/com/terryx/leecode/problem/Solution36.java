package com.terryx.leecode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author taoranxue on 8/13/17 7:26 PM.
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) return false;
        for (int i = 0; i < 9; ++i) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> cubSet = new HashSet<>();
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.' && !rowSet.add(board[i][j])) {
                    return false;
                }

                if (board[j][i] != '.' && !colSet.add(board[j][i])) {
                    return false;
                }
                // System.out.println(i + ", " + j +": " + (3*(i%3) + (j/3)) +" " + (3*(i/3) + (j%3)));
                if (board[3 * (i % 3) + (j / 3)][3 * (i / 3) + (j % 3)] != '.' && !cubSet.add(board[3 * (i % 3) + (j / 3)][3 * (i / 3) + (j % 3)])) {

                    return false;
                }
            }
            String s;

        }
        return true;
    }
}
