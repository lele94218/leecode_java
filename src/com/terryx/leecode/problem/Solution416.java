package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/31/17 9:18 AM.
 */
public class Solution416 {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) sum += nums[i];
        if (sum % 2 != 0) return false;
        sum /= 2;
        int dp[][] = new int[nums.length + 1][sum + 1];
        for (int i = 1; i <= nums.length; ++i) {
            for (int v = sum; v >= nums[i - 1]; --v) {
                dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - nums[i - 1]] + nums[i - 1]);
            }
        }
        return dp[nums.length][sum] == sum;
    }
}
