package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/1/17 10:03 AM.
 */
public class Solution10 {
    // DFS solution
//     public boolean isMatch(String s, String p) {
//         if (s == null || p == null) return false;
//         Map<Integer, Boolean> map = new HashMap<>();
//         return dfs(0, 0, s, p, map);
//     }

//     private boolean dfs(int cur1, int cur2, String s, String p, Map<Integer, Boolean> map) {
//         if (map.containsKey((cur1 << 15) + cur2))
//             return map.get((cur1 << 15) + cur2);
//         if (cur1 == s.length() && cur2 == p.length()) return true;
//         if (cur1 > s.length() || cur2 > p.length()) return false;
//         char c = (cur1 == s.length()) ? '\0' : s.charAt(cur1), cReg = (cur2 == p.length()) ? '\0' : p.charAt(cur2);
//         boolean ret = false;
//         if (cur2 + 1 < p.length() && p.charAt(cur2 + 1) == '*') {
//             // match '*' as one
//             if (c == cReg || cReg == '.')
//                 ret = dfs(cur1 + 1, cur2 + 2, s, p, map);

//             if (!ret) {
//                 // match '*' as zero
//                 ret = dfs(cur1, cur2 + 2, s, p, map);
//             }


//             if (!ret && (c == cReg || cReg == '.')) {
//                 // match '*' as many
//                 ret = dfs(cur1 + 1, cur2, s, p, map);
//             }
//         } else if (c == cReg || cReg == '.') {
//             ret = dfs(cur1 + 1, cur2 + 1, s, p, map);
//         }
//         map.put((cur1 << 15) + cur2, ret);
//         return ret;
//     }

    // DP solution
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int j = 1; j <= p.length(); ++j) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 1; j <= p.length(); ++j) {
                if (p.charAt(j - 1) != '*') {
                    if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                        dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 2] || (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') && dp[i - 1][j];
                }
            }
        }
        return false;
    }
}
