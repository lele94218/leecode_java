package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 10/17/16 9:36 PM.
 */
public class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int ans = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] < low) {
                low = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - low);
            }
        }
        return ans;
    }

    public int maxProfit1(int[] prices) {
        if (prices == null) return 0;
        if (prices.length <= 1) return 0;
        List<Integer> sub = new ArrayList<>();
        for (int i = 1; i < prices.length; ++i) {
            sub.add(prices[i] - prices[i - 1]);
        }
        int f[] = new int[sub.size() + 1];
        int res = 0;
        for (int i = 0; i < sub.size(); ++ i) {
            if (i == 0) f[i] = sub.get(i);
            else f[i] = Math.max(f[i-1] + sub.get(i), sub.get(i));
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
