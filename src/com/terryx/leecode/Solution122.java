package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/26/17 5:21 PM.
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        if (prices == null) return 0;
        int sub[] = new int[prices.length];
        for (int i = 1; i < prices.length; ++i) {
            sub[i] = prices[i] - prices[i - 1];
        }
        int res = 0;
        for (int i = 0; i < sub.length; ++i) {
            res += sub[i] > 0 ? sub[i] : 0;
        }
        return res;
    }
}
