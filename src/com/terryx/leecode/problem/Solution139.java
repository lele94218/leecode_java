package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/28/17 9:47 PM.
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null) return false;
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        // Set<String> set = new HashSet(wordDict);
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] == 1 && wordDict.contains(s.substring(j, i))) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        if (dp[s.length()] == 1) return true;
        return false;
    }
}
