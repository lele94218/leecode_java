package com.terryx.challenge.dp;

import java.util.*;

/**
 * @author taoranxue on 1/15/18 6:05 PM.
 */
public class POJ3167 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int map[][] = new int[t][t];
        for (int i = 1; i <= t; ++ i) {
            for (int j = 0; j < i; ++ j) {
                map[i - 1][j] = in.nextInt();
            }
        }
        int dp[][] = new int[t][t];

        for (int i = t - 1; i >= 0; -- i) {
            for (int j = 0; j <= i; ++ j) {
                if (i == t - 1) {
                    dp[i][j] = map[i][j];
                } else {
                    dp[i][j] = map[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }
}
