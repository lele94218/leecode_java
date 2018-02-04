package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/20/17 4:15 PM.
 */
public class Solution312 {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        int dp[][] = new int[nums.length][nums.length];
        for (int len = 0; len < nums.length; ++len) {
            for (int i = 0; i + len < nums.length; ++i) {
                int j = i + len;
                for (int k = i; k <= j; ++k) {
                    int tmp = nums[k] * (i - 1 >= 0 ? nums[i - 1] : 1) * (j + 1 < nums.length ? nums[j + 1] : 1);
                    tmp += (i <= k - 1 ? dp[i][k - 1] : 0) + (k + 1 <= j ? dp[k + 1][j] : 0);
                    dp[i][j] = Math.max(dp[i][j], tmp);
                }
            }
        }
        return dp[0][nums.length - 1];
        
    }
}
