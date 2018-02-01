package com.terryx.interview.facebook;

/**
 * @author taoranxue on 10/21/17 3:32 PM.
 */
public class RegularExpressionMatch {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return true;
        }
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        int idx = 1;
        while (idx < p.length() && p.charAt(idx) == '*') {
            dp[0][idx + 1] = true;
            idx += 2;
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                char c1 = s.charAt(i - 1), c2 = p.charAt(j - 1);
                dp[i][j] = ((c1 == c2 || c2 == '.') && dp[i - 1][j - 1])
                        || (c2 == '*' && ((c1 == p.charAt(j - 2) || p.charAt(j - 2) == '.') && (dp[i - 1][j] || dp[i - 1][j - 2]) || dp[i][j - 2]));
            }
        }
        return dp[s.length()][p.length()];
    }

    public boolean isMatchWildcard(String s, String p) {
        if (s == null || p == null) {
            return true;
        }
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        int idx = 0;
        while (idx < p.length() && p.charAt(idx) == '*') {
            dp[0][++idx] = true;
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                char c1 = s.charAt(i - 1), c2 = p.charAt(j - 1);
                dp[i][j] = (c1 == c2 || c2 == '?') && dp[i - 1][j - 1] || (c2 == '*' && (dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1]));
            }
        }
        return dp[s.length()][p.length()];
    }
}
