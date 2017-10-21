package com.terryx.gwualgorithm.facebook;

import com.terryx.main.Main;

import java.util.*;

/**
 * @author taoranxue on 10/19/17 2:19 PM.
 */
public class BuySellStock {
    /**
     * 只能买卖一次，最大利润。O(n) Time.
     * Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0, min = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            min = Math.min(prices[i], min);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    /**
     * Follow up 1: 可以买卖无数次，但是同一时间只能有一次交易，最大利润。 O(n) Time.
     * Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     */
    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < prices[i - 1]) {
                res += prices[i - 1] - min;
                min = prices[i];
            } else if (i == prices.length - 1) {
                res += prices[i] - min;
            }
        }
        return res;
    }

    /**
     * Follow up 2: 可以买卖k次，但是同一时间只能有一次交易，最大利润 O(n^2) time.
     * Source: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/description/
     */
    public int maxProfit2(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int min = prices[0], res = 0;
            for (int i = 1; i < prices.length; ++i) {
                if (prices[i] < prices[i - 1]) {
                    res += prices[i - 1] - min;
                    min = prices[i];
                }
                if (i == prices.length - 1) {
                    res += prices[i] - min;
                }
            }
            return res;
        }
        int dp[][] = new int[k + 1][prices.length + 1];
        for (int i = 1; i <= k; ++i) {
            int max = dp[i - 1][0] - prices[0];
            for (int j = 2; j <= prices.length; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j - 1]);
                max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1]);
            }
        }
        return dp[k][prices.length];
    }

    /**
     * Follow up 2: 可以买卖无数次，但是同一时间只能有一次交易，且每次交易额外收费f，求最大利润。 O(n^2) time.
     */
    public int maxProfit3(int[] prices, int f) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int dp[][] = new int[prices.length + 1][prices.length + 1];
        for (int i = 1; i <= prices.length; ++i) {
            int max = dp[i - 1][0] - prices[0] - f;
            for (int j = 2; j <= prices.length; ++j) {
                dp[i][j] = Math.max(dp[i][j - 1], max + prices[j - 1]);
                max = Math.max(max, dp[i - 1][j - 1] - prices[j - 1] - f);
            }
        }
        return dp[prices.length][prices.length];
    }

    public static void main(String[] args) {
        BuySellStock i = new BuySellStock();
        System.out.println(i.maxProfit3(new int[]{1, 3, 7, 5, 10, 3}, 3));
        System.out.println(i.maxProfit3(new int[]{1, 3, 7, 5, 10, 3}, 0));
        System.out.println(i.maxProfit3(new int[]{1, 3, 7, 5, 10, 3}, 4));
    }

}
