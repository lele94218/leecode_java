package com.terryx.leecode.weeklycontest.contest71;

import java.util.*;

/**
 * @author taoranxue on 2/13/18 4:26 PM.
 */
public class Solution782 {
    public int movesToChessboard(int[][] board) {
        if (board == null || board.length == 0) {
            return -1;
        }
        Map<Integer, Integer> count = new HashMap<>();
        int N = board.length;
        for (int i = 0; i < N; ++i) {
            int code = 0;
            for (int j = 0; j < N; ++j) {
                code = code * 2 + board[i][j];
            }
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        int k1, k2;
        if ((k1 = check(count, N)) == -1) {
            return -1;
        }

        count = new HashMap<>();
        for (int j = 0; j < N; ++j) {
            int code = 0;
            for (int i = 0; i < N; ++i) {
                code = code * 2 + board[i][j];
            }
            count.put(code, count.getOrDefault(code, 0) + 1);
        }

        if ((k2 = check(count, N)) == -1) {
            return -1;
        }

        return k1 + k2;
    }

    private int check(Map<Integer, Integer> count, int N) {
        if (count.size() != 2) {
            return -1;
        }
        List<Integer> keys = new ArrayList<>(count.keySet());
        int k1 = keys.get(0), k2 = keys.get(1);
        int bit1 = Integer.bitCount(k1), bit2 = Integer.bitCount(k2);
        if (!(bit1 == N / 2 && bit2 == (N + 1) / 2) && !(bit2 == N / 2 && bit1 == (N + 1) / 2)) {
            return -1;
        }
        int mask = (1 << N) - 1;
        if ((k1 ^ k2) != mask) {
            return -1;
        }
        int ret = Integer.MAX_VALUE;
        if (N % 2 == 0 || bit1 * 2 < N) {
            ret = Math.min(ret, Integer.bitCount(k1 ^ 0xaaaaaaaa & mask) / 2);
        }
        if (N % 2 == 0 || bit1 * 2 > N) {
            ret = Math.min(ret, Integer.bitCount(k1 ^ 0x55555555 & mask) / 2);
        }
        return ret;
    }

}
