package com.terryx.leecode.weeklycontest.contest55;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 2/8/18 8:00 PM.
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0;
        int dp[][] = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
//        for (int i = 0; i < dp.length; ++i) {
//            System.out.print(dp[i][0] + ", ");
//        }
//        System.out.println();
//        for (int i = 0; i < dp.length; ++i) {
//            System.out.print(dp[i][1] + ", ");
//        }
//        System.out.println();
        return Math.max(dp[prices.length - 1][0], dp[prices.length - 1][1]);
    }

    public static void main(String[] args) {
        Solution714 m = new Solution714();
        System.out.println(m.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
        System.out.println(m.maxProfit(new int[]{9, 8, 7, 1, 2}, 3));
    }
}
