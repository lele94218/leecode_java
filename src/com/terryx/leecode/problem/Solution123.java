package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/26/17 6:39 PM.
 */
public class Solution123 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int left[] = new int[prices.length], right[] = new int[prices.length];
        int low = prices[0], ans0 = 0;
        left[0] = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < low) {
                low = prices[i];
                left[i] = left[i - 1];
            } else {
                left[i] = Math.max(prices[i] - low, left[i - 1]);
            }
            ans0 = Math.max(ans0, left[i]);
        }
        int high = prices[prices.length - 1];
        right[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; --i) {
            if (prices[i] > high) {
                high = prices[i];
                right[i] = right[i + 1];
            } else {
                right[i] = Math.max(high - prices[i], right[i + 1]);
            }
        }
        int ans = 0;
        for (int i = 1; i < prices.length; ++i) {
            ans = Math.max(ans, left[i - 1] + right[i]);
        }

        return Math.max(ans, ans0);
    }
}
