package com.terryx.leecode.weeklycontest.contest49;

import java.util.*;

/**
 * @author taoranxue on 3/1/18 3:33 PM.
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n], res = 0;
        for (int i = 0; i < n; ++i) {
            dp1[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
            res = Math.max(dp1[i], res);
        }
        int dp[][] = new int[n][res + 1];
        for (int k = 1; k <= res; ++k) {
            for (int i = 0; i < n; ++i) {
                if (k == 1) dp[i][k] = 1;
                for (int j = 0; j < i; ++j) {
                    if (nums[i] > nums[j]) {
                        dp[i][k] += dp[j][k - 1];
                    }
                }
            }
        }
        int res0 = 0;
        for (int i = 0; i < n; ++ i) res0 += dp[i][res];
        return res0;
    }

    public static void main(String[] args) {
        Solution673 m = new Solution673();
        System.out.println(m.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(m.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(m.findNumberOfLIS(new int[]{1, 0, 1, 2, 1}));
    }
}
