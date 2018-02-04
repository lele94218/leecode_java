package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/16/17 7:49 PM.
 */
public class Solution689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = 3;
        int ans[] = new int[n];
        int dp[][] = new int[n + 1][nums.length + 1];
        int start[][] = new int[n + 1][nums.length + 1];
        int sum[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = k; j <= nums.length; ++j) {
                dp[i][j] = dp[i][j - 1];
                start[i][j] = start[i][j - 1];
                int choose = j - k >= 0 ? dp[i - 1][j - k] + sum[j] - sum[j - k] : 0;
                if (choose > dp[i][j]) {
                    dp[i][j] = choose;
                    start[i][j] = j - k + 1;
                }

                //dp[i][j] = Math.max((j - k >= 0 ? dp[i - 1][j - k] + sum[j] - sum[j - k] : 0), dp[i][j - 1]);
            }
        }
        // System.out.println(dp[n][nums.length]);
        // for (int i = 0; i <= n; ++ i) {
        //     for (int j = 0; j <= nums.length; ++ j) {
        //         System.out.print(start[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        //     System.out.println();
        // for (int i = 0; i <= n; ++ i) {
        //     for (int j = 0; j <= nums.length; ++ j) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        int p = 0;
        for (int i = n; i >= 1; --i) {
            if (i == n) {
                p = start[i][nums.length];
            } else {
                p = start[i][p];
            }
            ans[i - 1] = --p;
        }
        return ans;
    }
}
