package com.terryx.tiaozhan.dp;

import java.util.*;

/**
 * @author taoranxue on 1/15/18 6:52 PM.
 */
public class POJ2385 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(), w = in.nextInt();
        int apples[] = new int[t];
        for (int i = 0; i < t; ++i) {
            apples[i] = in.nextInt();
        }
        int dp[][] = new int[t][w + 1];
        for (int i = 0; i <= w; ++i) {
            dp[0][i] = (apples[i] == (i % 2 + 1)) ? 1 : 0;
        }
        for (int i = 1; i < t; ++ i) {
            for (int j = 0; j <= w; ++ j) {
                dp[i][j] = Math.max(dp[i - 1][j], (j - 1 >= 0) ? dp[i - 1][j - 1] : dp[i - 1][0])
                        + (apples[i] == (j % 2 + 1) ? 1 : 0);
            }
        }

        int res = 0;
        for (int i = 0; i <= w; ++ i) {
            res = Math.max(res, dp[t - 1][i]);
        }
        System.out.println(res);

    }
}
