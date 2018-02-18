package com.terryx.leecode.weeklycontest.contest72;

import java.util.*;

/**
 * @author taoranxue on 2/17/18 10:16 PM.
 */
public class Solution787 {

    static class Pair {
        int index, len;

        Pair(int index, int len) {
            this.index = index;
            this.len = len;
        }
    }

    public int findCheapestPrice(int N, int[][] flights, int src, int dst, int K) {

        int dp[][] = new int[N][K + 1];
        int mat[][] = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(mat[i], -1);
        }
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int[] edge : flights) {
            mat[edge[0]][edge[1]] = edge[2];
            if (edge[1] == dst) {
                dp[edge[0]][0] = edge[2];
            }
        }

        dp[dst][0] = 0;

        for (int k = 1; k <= K; ++k) {
            for (int u = 0; u < N; ++u) {
                for (int v = 0; v < N; ++v) {
                    if (mat[u][v] > 0 && dp[v][k - 1] + mat[u][v] < dp[u][k]) {
                        System.out.println(u + " " + v);
                        dp[u][k] = dp[v][k - 1] + mat[u][v];
                    }
                }
            }
        }
        return (dp[src][K] == Integer.MAX_VALUE) ? -1 : dp[src][K];
    }

    public static void main(String[] args) {
        Solution787 m = new Solution787();
//        System.out.println(m.findCheapestPrice(
//                3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0
//        ));

        System.out.println(m.findCheapestPrice(
                5, new int[][]{{4, 1, 1}, {1, 2, 3}, {0, 3, 2}, {0, 4, 10}, {3, 1, 1}, {1, 4, 3}}, 2, 1, 1
        ));
    }
}
