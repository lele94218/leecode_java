package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/28/17 11:34 PM.
 */
public class Solution338 {
    public int[] countBits(int num) {
        int dp[] = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        return dp;
    }
}
