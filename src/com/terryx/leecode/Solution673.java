package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/27/17 12:07 AM.
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int dp[] = new int[nums.length], cnt[] = new int[nums.length], len = 0, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            dp[i] = cnt[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if (len == dp[i]) {
                res += cnt[i];
            }
            if (len < dp[i]) {
                len = dp[i];
                res = cnt[i];
            }
        }
        return res;
    }
}
