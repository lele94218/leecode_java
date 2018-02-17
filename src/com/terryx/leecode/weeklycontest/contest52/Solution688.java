package com.terryx.leecode.weeklycontest.contest52;

import java.util.*;

/**
 * @author taoranxue on 2/16/18 6:35 PM.
 */
public class Solution688 {
    public double knightProbability(int N, int K, int r, int c) {
        List<Integer> lists[] = new List[N * N];
        int dx[] = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        int dy[] = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int code = i * N + j;
                lists[code] = new ArrayList<>();
                for (int k = 0; k < 8; ++ k) {
                    int nx = i + dx[k], ny = j + dy[k], ncode = nx * N + ny;
                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        lists[code].add(ncode);
                    }
                }
            }
        }
        double dp[][] = new double[N * N][K + 1];
        for (int i = 0; i < N; ++ i) {
            for (int j = 0; j < N; ++ j) {
                int code = i * N + j;
                dp[code][0] = 1.0;
            }
        }

        for (int k = 1; k <= K; ++ k) {
            for (int i = 0; i < N; ++ i) {
                for (int j = 0; j < N; ++ j) {
                    int code = i * N + j;
                    double sum = 0.0;
                    for (Integer ncode : lists[code]) {
                        sum += dp[ncode][k - 1];
                    }
                    dp[code][k] = sum / 8.0;
//                    System.out.println(dp[code][k]);
                }
            }
        }

        return dp[r * N + c][K];
    }

    public static void main(String[] args) {
        Solution688 m = new Solution688();
        System.out.println(m.knightProbability(3, 2, 0, 0));
    }
}
