package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/29/17 9:36 PM.
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>(0);
        int dp[] = new int[nums.length];
        int pa[] = new int[nums.length];
        Arrays.sort(nums);
        List res = new ArrayList<>(0);
        int cnt = 0, index = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    pa[i] = j;
                }
            }
            if (cnt < dp[i]) {
                index = i;
                cnt = dp[i];
            }
        }


        for (int i = 0; i <= cnt; ++i) {
            res.add(nums[index]);
            index = pa[index];
        }

        return res;
    }
}
