package com.terryx.leecode.weeklycontest.contest49;

import java.util.*;

/**
 * @author taoranxue on 3/1/18 3:33 PM.
 */
public class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp1[] = new int[n], dp2[] = new int[n], res = 0;
        Arrays.fill(dp2, 1);
        for (int i = 0; i < n; ++i) {
            dp1[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    if (dp1[j] + 1 > dp1[i]) {
                        dp2[i] = dp2[j];
                        dp1[i] = dp1[j] + 1;
                    } else if (dp1[j] + 1 == dp1[i]) {
                        dp2[i] += dp2[j];
                    }
                }
            }
            res = Math.max(dp1[i], res);
        }
        int res0 = 0;
        for (int i = 0; i < n; ++i)
            if (dp1[i] == res) {
                res0 += dp2[i];
            }
        return res0;
    }

    public static void main(String[] args) {
        Solution673 m = new Solution673();
        System.out.println(m.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(m.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));
        System.out.println(m.findNumberOfLIS(new int[]{1, 0, 1, 2, 1}));
    }
}
