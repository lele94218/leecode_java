package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/26/17 6:57 PM.
 */
public class Solution188 {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        if (k > prices.length / 2) {
            int res = 0;
            for (int i = 1; i < prices.length; ++i) {
                int t = -1;
                if ((t = prices[i] - prices[i - 1]) > 0) res += t;
            }
            return res;
        }
        int dp[][] = new int[k + 1][prices.length];
        for (int i = 1; i <= k; ++i) {
            int tMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + tMax);
                tMax = Math.max(tMax, dp[i - 1][j - 1] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }
}
