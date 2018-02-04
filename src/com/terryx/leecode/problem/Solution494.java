package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 11:35 AM.
 */
public class Solution494 {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        int dp[][] = new int[nums.length + 1][(2000 << 1) + 1];
        dp[0][2000] = 1;
        for (int i = 1; i <= nums.length; ++i) {
            for (int j = -1000; j <= 1000; ++j) {
                dp[i][j + 2000] = dp[i - 1][j - nums[i - 1] + 2000] + dp[i - 1][j + nums[i - 1] + 2000];
            }
        }
        return S > 1000 ? 0 : dp[nums.length][S + 2000];
    }
}
