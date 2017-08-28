package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/28/17 11:08 PM.
 */
public class Solution140 {
    // DFS solution
    private Map<Integer, List<String>> map;

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<>(0);
        map = new HashMap<>();
        return dfs(s, 0, wordDict);
    }

    private List<String> dfs(String s, int cur, List<String> wordList) {
        if (map.containsKey(cur)) return map.get(cur);
        List<String> ret = new ArrayList<>();
        for (int i = cur; i <= s.length(); ++i) {
            if (wordList.contains(s.substring(cur, i))) {
                // System.out.println(s.substring(cur, i) + " " + cur);
                List<String> list = dfs(s, i, wordList);
                if (list.size() > 0) {
                    for (String word : list) {
                        ret.add(s.substring(cur, i) + " " + word);
                    }
                } else if (i == s.length()) {
                    ret.add(s.substring(cur, i));
                }
            }
        }
        map.put(cur, ret);
        return ret;
    }

    // DP TLE
//     public List<String> wordBreak(String s, List<String> wordDict) {
//         if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<>(0);
//         List<String> dp[] = new List[s.length() + 1];
//         dp[0] = new ArrayList<>();
//         dp[0].add("");

//         for (int i = 1; i <= s.length(); ++ i) {
//             dp[i] = new ArrayList<>();
//             for (int j = 0; j < i; ++ j) {
//                 String str = s.substring(j, i);
//                 System.out.println(str);
//                 if (dp[j].size() > 0 && wordDict.contains(str)) {
//                     for (String word : dp[j]) {
//                         if ("".equals(word))
//                             dp[i].add(str);
//                         else
//                             dp[i].add(word + " " + str);
//                     }
//                 }
//             }
//         }
//         return dp[s.length()];
//     }


}
