package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/26/17 5:21 PM.
 */
public class Solution122 {

    /**
     * Space O(n)
     */
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

    /**
     * Space O(1)
     */
    public int maxProfit0(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int res = 0, min = prices[0];
        for (int i = 1; i < prices.length; ++ i) {
            if (prices[i] < prices[i - 1]) {
                res += prices[i - 1] - min;
                min = prices[i];
            } else if (i == prices.length - 1) {
                res += prices[i] - min;
            }
        }
        return res;
    }
}
