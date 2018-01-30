package com.terryx.leecode.weeklycontest.contest67;

import java.util.*;

/**
 * @author taoranxue on 1/13/18 9:57 PM.
 */
public class Solution764 {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        if (mines == null) {
            return 0;
        }
        int map[][] = new int[N][N];
        for (int i = 0; i < map.length; ++i) {
            Arrays.fill(map[i], 1);
        }
        for (int[] pos : mines) {
            map[pos[0]][pos[1]] = 0;
        }

        int left[][] = new int[N][N];
        int right[][] = new int[N][N];
        int up[][] = new int[N][N];
        int down[][] = new int[N][N];

        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                if (j == 0) {
                    left[i][j] = map[i][j];
                } else {
                    left[i][j] = map[i][j] == 0 ? 0 : 1 + left[i][j - 1];
                }
            }

            for (int j = map[i].length - 1; j >= 0; --j) {
                if (j == map[i].length - 1) {
                    right[i][j] = map[i][j];
                } else {
                    right[i][j] = map[i][j] == 0 ? 0 : 1 + right[i][j + 1];
                }
            }
        }

        for (int j = 0; j < map[0].length; ++j) {
            for (int i = 0; i < map.length; ++i) {
                if (i == 0) {
                    down[i][j] = map[i][j];
                } else {
                    down[i][j] = map[i][j] == 0 ? 0 : 1 + down[i - 1][j];
                }
            }

            for (int i = map.length - 1; i >= 0; --i) {
                if (i == map.length - 1) {
                    up[i][j] = map[i][j];
                } else {
                    up[i][j] = map[i][j] == 0 ? 0 : 1 + up[i + 1][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < map.length; ++i) {
            for (int j = 0; j < map[i].length; ++j) {
                int t = Math.min(down[i][j], Math.min(up[i][j], Math.min(left[i][j], right[i][j])));
                res = Math.max(res, t);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution764 m = new Solution764();
        System.out.println(m.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));
        System.out.println(m.orderOfLargestPlusSign(2, new int[][]{}));
        System.out.println(m.orderOfLargestPlusSign(6, new int[][]{}));
        System.out.println(m.orderOfLargestPlusSign(1, new int[][]{{0, 0}}));
    }
}
