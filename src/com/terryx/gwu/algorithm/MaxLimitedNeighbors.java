package com.terryx.gwu.algorithm;

/**
 * You are given an array a[1..n] of positive numbers and an integer k. You have to produce an
 * array b[1..n], such that: (i) For each j, b[j] is 0 or 1, (ii) Array b has adjacent 1s at most
 * k times, and (iii) sum_{j=1 to n} a[j]*b[j] is maximized. For example, given an array [100, 300, 400, 50]
 * and integer k = 1, the array b can be: [0 1 1 0], which maximizes the sum to be 700. Or,
 * given an array [10, 100, 300, 400, 50, 4500, 200, 30, 90] and k = 2, the array b can be
 * [1, 0, 1, 1, 0, 1, 1, 0, 1] which maximizes the sum to 5500.
 * <p>
 * To be precise about the definition of adjacency: sequence [0, 1, 0, 1, 0, 1, 1, 1] has two adjacent 1s.
 * Sequence [0, 1, 0, 0, 1, 1, 1, 1] has 3 adjacent 1s. Sequence [1, 0, 1, 1, 0, 1, 1, 1] also has 3 adjacent 1s.
 *
 * @author taoranxue on 10/23/16 5:34 PM.
 */
public class MaxLimitedNeighbors {
    public static int solve(int[] a, int k) {
        int n = a.length;
        int dp[][] = new int[k + 1][n + 1];
        //init k = 0
        for (int i = 0; i < n; ++i) {
            if (i > 1)
                dp[0][i + 1] = Math.max(dp[0][i], a[i] + dp[0][i - 1]);
            else
                dp[0][i + 1] = Math.max(dp[0][i], a[i]);
        }
        for (int i = 1; i <= k; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j > 0)
                    dp[i][j + 1] = Math.max(Math.max(dp[i][j], dp[i][j - 1] + a[j]), dp[i - 1][j] + a[j]);
                else
                    dp[i][j + 1] = Math.max(dp[i][j], dp[i - 1][j] + a[j]);
            }
        }
        return dp[k][n];
    }

    public static void main(String args[]) {
        int a[] = new int[]{1,2,3,4,5,6};
        System.out.println(solve(a, 6));
    }
}
