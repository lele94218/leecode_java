package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 12:30 PM.
 */
public class Solution516 {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int dp[][] = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++i) {
            dp[i][i] = 1;
        }
        for (int len = 1; len < s.length(); ++len) {
            for (int i = 0; i < s.length() - len; ++i) {
                int j = i + len;
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                if (s.charAt(i) == s.charAt(j))
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 2);
                // System.out.println(dp[i][j] + " " + i + " " + j);
            }
        }
        return dp[0][s.length() - 1];
    }
}
