package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/31/17 11:28 AM.
 */
public class Solution467 {
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) return 0;
        int curLength = 0;
        // dp[c] max length end with letter 'c'
        int dp[] = new int[26];
        for (int i = 0; i < p.length(); ++i) {
            if (i > 0 && (p.charAt(i) - p.charAt(i - 1) + 26) % 26 == 1) {
                curLength++;
            } else {
                curLength = 1;
            }
            int c = p.charAt(i) - 'a';
            dp[c] = Math.max(dp[c], curLength);
        }
        int res = 0;
        for (int i = 0; i < 26; ++i) {
            res += dp[i];
        }
        return res;
    }
}
