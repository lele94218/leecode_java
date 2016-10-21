package com.terryx.leecode;

/**
 * @author taoranxue on 10/21/16 1:55 PM.
 */
public class Solution309 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int sell[] = new int[prices.length + 1];
        int buy[] = new int[prices.length + 1];
        sell[1] = 0;
        buy[1] = -prices[0];
        for (int i = 1; i < prices.length; ++i) {
            sell[i + 1] = Math.max(sell[i], buy[i] + prices[i]);
            buy[i + 1] = Math.max(buy[i], sell[i - 1] - prices[i]);
        }
        return Math.max(sell[prices.length], buy[prices.length]);
    }
}
