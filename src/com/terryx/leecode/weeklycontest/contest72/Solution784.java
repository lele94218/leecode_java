package com.terryx.leecode.weeklycontest.contest72;

import java.util.*;

/**
 * @author taoranxue on 2/17/18 9:30 PM.
 */
public class Solution784 {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        dfs(S, "", 0, res);
        return res;
    }

    private void dfs(String s, String path, int cur, List<String> res) {
        if (cur >= s.length()) {
            res.add(path);
            return;
        }
        char c = s.charAt(cur);
        if (Character.isLetter(c)) {
            dfs(s, path + Character.toLowerCase(c), cur + 1, res);
            dfs(s, path + Character.toUpperCase(c), cur + 1, res);
        } else {
            dfs(s, path + c, cur + 1, res);
        }
    }

    public static void main(String[] args) {
        Solution784 m = new Solution784();
        System.out.println(m.letterCasePermutation("a1b2"));
        System.out.println(m.letterCasePermutation("3z4"));
        System.out.println(m.letterCasePermutation("12345"));
    }
}
