package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/31/17 12:06 PM.
 */
public class Solution474 {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) return 0;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; ++i) {
            String word = strs[i];
            int vm = 0, vn = 0;
            for (int j = 0; j < word.length(); ++j) {
                if (word.charAt(j) == '0') vm++;
                if (word.charAt(j) == '1') vn++;
            }
            for (int j = m; j >= vm; --j) {
                for (int k = n; k >= vn; --k) {
                    dp[j][k] = Math.max(dp[j - vm][k - vn] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
}
