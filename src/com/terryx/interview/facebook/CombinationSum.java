package com.terryx.interview.facebook;

/**
 * @author taoranxue on 10/21/17 5:52 PM.
 */
public class CombinationSum {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < nums.length; ++j) {
                dp[i] += (i - nums[j] >= 0 ? dp[i - nums[j]] : 0);
            }
        }
        return dp[target];
    }
}
