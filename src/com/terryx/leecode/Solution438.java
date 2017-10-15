package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/14/17 2:51 PM.
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s == null || p == null) {
            return ans;
        }
        int map[] = new int[256];
        for (int i = 0; i < p.length(); ++i) {
            map[p.charAt(i)]++;
        }
        int begin = 0, end = 0, cnt = p.length();
        for (; end < s.length(); ++end) {
            if (map[s.charAt(end)]-- > 0) {
                cnt--;
            }
            if (cnt == 0) {
                while (cnt == 0) {
                    if (map[s.charAt(begin)]++ == 0) {
                        cnt++;
                    }
                    begin++;
                }
                if (end - begin + 2 == p.length()) {
                    ans.add(begin - 1);
                }
            }
        }
        return ans;
    }
}
