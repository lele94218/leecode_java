package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/14/17 12:53 PM.
 */
public class Solution301 {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null) return new ArrayList<>(0);
        List<String> res = new ArrayList<>();
        dfs(s, 0, 0, res, new char[]{'(', ')'});
        return res;
    }

    private void dfs(String s, int cur, int lastRemoveIdx, List<String> res, char[] prths) {
        // System.out.println("-->" + s);
        int left = 0;
        for (int i = cur; i < s.length(); ++i) {
            if (s.charAt(i) == prths[0]) left++;
            if (s.charAt(i) == prths[1]) left--;
            if (left >= 0) continue;
            for (int j = lastRemoveIdx; j <= i; ++j) {
                if (s.charAt(j) == prths[1] && (j == lastRemoveIdx || s.charAt(j) != s.charAt(j - 1))) {
                    dfs(s.substring(0, j) + s.substring(j + 1, s.length()), i, j, res, prths);
                }
            }
            return;
        }
        // System.out.println(s);
        String reverse = new StringBuilder(s).reverse().toString();
        if (prths[0] == '(') {
            dfs(reverse, 0, 0, res, new char[]{')', '('});
        } else {
            res.add(reverse);
        }
    }
}
