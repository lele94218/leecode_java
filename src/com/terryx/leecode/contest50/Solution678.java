package com.terryx.leecode.contest50;

import java.util.*;

/**
 * @author taoranxue on 9/16/17 10:05 PM.
 */
public class Solution678 {
    // O(n)
    // public boolean checkValidString(String s) {
    //     if (s == null || s.length() == 0) return true;
    //     int low = 0, high = 0;
    //     for (int i = 0; i < s.length(); ++ i) {
    //         char c = s.charAt(i);
    //         low += c == '(' ? 1 : -1;
    //         high += c != ')' ? 1 : -1;
    //         if (high < 0) return false;
    //         low = Math.max(low, 0);
    //     }
    //     return high >= 0 && low <= 0;
    // }

    // O(n^3) DP
    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;
        boolean dp[][] = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); ++ i) {
            if (s.charAt(i) == '*') dp[i][i] = true;
            if (i < s.length() - 1) {
                if ((s.charAt(i) == '(' || s.charAt(i) == '*') && (s.charAt(i + 1) == ')' || s.charAt(i + 1) == '*'))
                    dp[i][i + 1] = true;
            }
        }

        for (int len = 2; len < s.length(); ++ len) {
            for (int i = 0; i < s.length() - len; ++ i) {
                int j = i + len;
                if (s.charAt(i) == '*' || s.charAt(i) == '(') {
                    for (int k = i + 1; k <= j; ++ k) if (s.charAt(k) == '*' || s.charAt(k) == ')') {
                        dp[i][j] = dp[i][j] ||
                                (i + 1 <= k - 1 ? dp[i + 1][k - 1] : true) && (k + 1 <= j ? dp[k + 1][j] : true);
                    }
                }
            }
        }
        // for (int i = 0; i < s.length(); ++ i) {
        //     for (int j = i; j < s.length(); ++ j) {
        //         System.out.println(i + " " + j + ": " + dp[i][j]);
        //     }
        // }
        return dp[0][s.length() - 1];
    }
}
