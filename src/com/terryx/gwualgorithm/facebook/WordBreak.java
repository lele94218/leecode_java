package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/20/17 6:33 PM.
 */
public class WordBreak {
    /**
     * For example, given
     * s = "leetcode",
     * dict = ["leet", "code"].
     *
     * Return true because "leetcode" can be segmented as "leet code".
     */
    public boolean wordBreak1(String s, List<String> wordDict) {
        if (s == null) {
            return true;
        }
        boolean dp[] = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); ++i) {
            for (int j = 0; j < i; ++j) {
                if (dp[j] && ("".equals(s.substring(j, i)) || wordDict.contains(s.substring(j, i)))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }

    /**
     * For example, given
     * s = "catsanddog",
     * dict = ["cat", "cats", "and", "sand", "dog"].
     *
     * A solution is ["cats and dog", "cat sand dog"].
     */
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        if (s == null || wordDict == null) {
            return ans;
        }
        Map<String, List<String>> map = new HashMap<>();
        return dfs(s, wordDict, map);
    }

    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> ret = new ArrayList<>();
        if (s.length() == 0) {
            ret.add("");
        } else {
            for (int i = 1; i <= s.length(); ++i) {
                if (wordDict.contains(s.substring(0, i))) {
                    List<String> list = dfs(s.substring(i, s.length()), wordDict, map);
                    for (String str : list) {
                        if ("".equals(str)) {
                            ret.add(s.substring(0, i));
                        } else {
                            ret.add(s.substring(0, i) + " " + str);
                        }
                    }
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
}
