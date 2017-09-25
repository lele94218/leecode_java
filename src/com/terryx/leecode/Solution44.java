package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/24/17 7:02 PM.
 */
public class Solution44 {
    // DP version
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        int idx = p.length() - 1;
        while (idx >= 0 && p.charAt(idx) == '*') {
            dp[s.length()][idx] = true;
            idx--;
        }
        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = p.length() - 1; j >= 0; --j) {
                dp[i][j] = (p.charAt(j) == '*' && (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j + 1])) ||
                        ((p.charAt(j) == '?' || (s.charAt(i) == p.charAt(j))) && (dp[i + 1][j + 1]));
            }
        }
        return dp[0][0];
    }

    // DFS version
//     public boolean isMatch(String s, String p) {
//         if (s == null || p == null) return false;
//         Map<Integer, Boolean>[] maps = new Map[s.length() + 1];
//         return dfs(s, p, 0, 0, maps);
//     }

//     private boolean dfs(String s, String p, int i, int j, Map<Integer, Boolean>[] maps) {
//         if (maps[i] == null) maps[i] = new HashMap<>();
//         if (maps[i].containsKey(j)) return maps[i].get(j);
//         boolean res = true;
//         if (i == s.length()) {
//             if (j == p.length())
//                 res = true;
//             else {
//                 String str = p.substring(j, p.length());
//                 for (int ix = 0; ix < str.length(); ++ ix) {
//                     if (str.charAt(ix) != '*') {
//                         res = false;
//                     }
//                 }
//             }
//         } else if (i == s.length() || j == p.length()) {
//             res = false;
//         } else {
//             char pc = p.charAt(j);
//             if (pc == '*') {
//                 res = dfs(s, p, i + 1, j + 1, maps) || dfs(s, p, i, j + 1, maps) || dfs(s, p, i + 1, j, maps);
//             } else if (pc == '?') {
//                 res = dfs(s, p, i + 1, j + 1, maps);
//             } else {
//                 res = s.charAt(i) == p.charAt(j) && dfs(s, p, i + 1, j + 1, maps);
//         }
//         }
//         maps[i].put(j, res);
//         return res;
//     }
}
