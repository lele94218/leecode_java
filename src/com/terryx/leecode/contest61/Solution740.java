package com.terryx.leecode.contest61;

import java.util.*;

/**
 * @author taoranxue on 1/23/18 3:54 PM.
 */
public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int cnt[] = new int[10010];

        for (int num : nums) {
            cnt[num]++;
        }

        int dp[][] = new int[10010][2]; // 0 take, 1 no take
        for (int i = 1; i <= 10000; ++i) {
            if (cnt[i] > 0) {
                dp[i][0] = Math.max(dp[i - 1][1], i - 2 >= 0 ? dp[i - 2][0] : 0) + cnt[i] * i;
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            } else {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = dp[i - 1][1];
            }
        }
        return Math.max(dp[10000][0], dp[10000][1]);
    }

    public static void main(String[] args) {
        Solution740 m = new Solution740();
        System.out.println(m.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(m.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
