package com.terryx.leecode.lcode.search;

import java.util.*;

/**
 * @author taoranxue on 10/11/17 7:14 PM.
 */
public class Parentheses {
    /**
     * Given N pairs of parentheses “()”, return a list with all the valid permutations.
     * <p>
     * Assumptions
     * <p>
     * N >= 0
     * Examples
     * <p>
     * N = 1, all valid permutations are ["()"]
     * N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]
     * N = 0, all valid permutations are [""]
     */
    public List<String> validParentheses(int n) {
        List<String> ans = new ArrayList<>();
        validParenthesesHelper(0, n, n, new char[n << 1], ans);
        return ans;
    }

    private void validParenthesesHelper(int cur, int left, int right, char[] path, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(new String(path));
            return;
        }


        if (left > 0) {
            path[cur] = '(';
            validParenthesesHelper(cur + 1, left - 1, right, path, ans);
        }

        if (right > 0 && right > left) {
            path[cur] = ')';
            validParenthesesHelper(cur + 1, left, right - 1, path, ans);
        }
    }
}
