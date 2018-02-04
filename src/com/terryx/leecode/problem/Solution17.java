package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taoranxue on 10/25/16 9:13 PM.
 */
public class Solution17 {
    public List<String> letterCombinations0(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        ans.add("");
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); ++ i) {
            char c = digits.charAt(i);
            List<String> next = new ArrayList<>();
            for (String prev : ans) {
                for (int j = 0; j < map[c - '0'].length(); ++ j) {
                    next.add(prev + map[c - '0'].charAt(j));
                }
            }
            ans = next;
        }
        return ans;
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>(0);
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        dfs(digits, 0, ans, "", map);
        return ans;
    }

    private void dfs(String digits, int cur, List<String> ans, String path, String[] map) {
        if (cur == digits.length()) {
            ans.add(path);
            return;
        }
        String t = map[digits.charAt(cur) - '0'];
        for (int j = 0; j < t.length(); ++j) {
            dfs(digits, cur + 1, ans, path + t.charAt(j), map);
        }
    }
}
