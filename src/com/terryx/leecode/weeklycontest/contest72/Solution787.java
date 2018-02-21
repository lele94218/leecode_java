package com.terryx.leecode.weeklycontest.contest72;

import java.util.*;

/**
 * @author taoranxue on 2/17/18 10:16 PM.
 */
public class Solution787 {
    public int findCheapestPrice(int N, int[][] flights, int src, int dst, int K) {
        int dp[][] = new int[N][K + 2];
        int graph[][] = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int[] edge : flights) {
            graph[edge[0]][edge[1]] = edge[2];
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        queue.offer(new int[]{0, 0, src});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cost = cur[0], k = cur[1], from = cur[2];
            if (from == dst) {
                return cost;
            }
            if (k >= K + 1 || cost > dp[from][k]) {
                continue;
            }
            for (int to = 0; to < N; to++) {
                if (graph[from][to] > 0) {
                    int newCost = cost + graph[from][to];
                    if (newCost < dp[to][k + 1]) {
                        queue.offer(new int[]{newCost, k + 1, to});
                        dp[to][k + 1] = newCost;
                    }
                }
            }
        }
        return -1;
    }

    public int findCheapestPrice2(int N, int[][] flights, int src, int dst, int K) {
        int dp[][] = new int[N][K + 1];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[src][0] = 0;
        for (int k = 1; k <= K; ++k) {
            for (int i = 0; i < N; ++i) {
                dp[i][k] = dp[i][k - 1];
            }
            for (int[] edge : flights) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dp[u][k - 1] != Integer.MAX_VALUE) {
                    dp[v][k] = Math.min(dp[v][k], dp[u][k - 1] + w);
                }
            }
        }
        return dp[dst][K] == Integer.MAX_VALUE ? -1 : dp[dst][K];
    }

    public int findCheapestPrice1(int N, int[][] flights, int src, int dst, int K) {

        int dp[][] = new int[N][K + 1];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int[] edge : flights) {
            if (edge[1] == dst) {
                dp[edge[0]][0] = edge[2];
            }
        }

        dp[dst][0] = 0;

        for (int k = 1; k <= K; ++k) {
            for (int[] edge : flights) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (w >= 0 && dp[v][k - 1] != Integer.MAX_VALUE && dp[v][k - 1] + w < dp[u][k]) {
                    dp[u][k] = dp[v][k - 1] + w;
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int k = 0; k <= K; ++k) {
            res = Math.min(res, dp[src][k]);
        }
        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static void main(String[] args) {
        Solution787 m = new Solution787();
        System.out.println(m.findCheapestPrice(
                3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0,
                2,
                1)
        );
    }
}
