package com.terryx.leecode.weeklycontest.contest57;

import java.util.*;

/**
 * @author taoranxue on 1/31/18 7:18 PM.
 */
public class Solution720 {
    int max = 0;
    String res = "";

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Set<String> set = new HashSet<>();
        set.addAll(Arrays.asList(words));
        dfs("", set);
        return res;
    }

    private void dfs(String path, Set<String> set) {
        StringBuilder sb = new StringBuilder(path);
        for (int i = 0; i < 26; ++i) {
            String tmp = path + (char) ('a' + i);
            if (set.contains(tmp)) {
                if (tmp.length() > max) {
                    max = tmp.length();
                    res = tmp;
                }
                dfs(tmp, set);
            }
        }
    }

    public static void main(String[] args) {
        Solution720 m = new Solution720();
        //System.out.println(m.longestWord(new String[]{"w","wo","wor","worl", "world"}));
        System.out.println(m.longestWord(new String[]{"d", "a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }
}
