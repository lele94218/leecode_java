package com.terryx.leecode.weeklycontest.contest63;

/**
 * @author taoranxue on 1/18/18 7:39 PM.
 */
public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0 || cost.length == 1) {
            return 0;
        }
        int dp[] = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; ++ i) {
            dp[i] = Math.min(dp[i - 2] + cost[i - 2], dp[i - 1] + cost[i - 1]);
        }
        return dp[cost.length];
    }

    public static void main(String[] args) {
        Solution746 m = new Solution746();
        System.out.println(m.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
