package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/19/18 8:54 PM.
 */
public class Solution351 {

    public int numberOfPatterns(int m, int n) {
        int dp[][] = new int[9][1 << 9];

        int jumps[][] = new int[10][10];
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        jumps[1][9] = jumps[9][1] = jumps[3][7] = jumps[7][3] = 5;
        for (int j = 1; j < (1 << 9); ++j) {
            for (int i = 0; i < 9; ++i) {
                if (((1 << i) & j) != 0) {
                    if ((j - (1 << i)) == 0) {
                        dp[i][j] = 1;
                    } else {
                        for (int k = 0; k < 9; ++k)
                            if (i != k && ((1 << k) & j) != 0) {
                                boolean flag = true;
                                for (int pass = 0; pass < 9; ++pass) {
                                    if (((1 << pass) & j) == 0 && pass + 1 == jumps[i + 1][k + 1]) {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    dp[i][j] += dp[k][j - (1 << i)];
                                }
                            }
                    }
                }
            }
        }

        int res = 0;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < (1 << 9); ++j) {
                int cnt = Integer.bitCount(j);
                if (cnt >= m && cnt <= n) {
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}
