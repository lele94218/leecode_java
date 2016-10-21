package com.terryx.leecode;

import java.util.Arrays;

/**
 * @author taoranxue on 10/20/16 9:16 PM.
 */
public class Solution322 {
    public int coinChange(int[] coins, int amount) {
        int d[] = new int[amount + 1];
        Arrays.fill(d, Integer.MAX_VALUE - 1);
        d[0] = 0;
        int n = coins.length;
        for (int coin : coins) {
            for (int i = coin; i <= amount; ++i) {
                d[i] = Math.min(d[i], d[i - coin] + 1);
            }
        }
        if (d[amount] == Integer.MAX_VALUE || d[amount] < 0) return -1;
        return d[amount];
    }

}
