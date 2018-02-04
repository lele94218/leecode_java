package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/21/17 4:13 PM.
 */
public class Solution72 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 1; i <= word1.length(); ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); ++i) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); ++i) {
            for (int j = 1; j <= word2.length(); ++j) {
                char c1 = word1.charAt(i - 1), c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                int res = Integer.MAX_VALUE;
                // insert or delete
                res = Math.min(res, Math.min(dp[i][j - 1], dp[i - 1][j]) + 1);
                // replace
                res = Math.min(res, dp[i - 1][j - 1] + 1);
                dp[i][j] = res;
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
