package com.terryx.leecode;

import java.util.HashMap;

/**
 * @author taoranxue on 8/12/17 9:38 AM.
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); ++j) {
            if (map.containsKey(s.charAt(j))) {
                // System.out.println("ok");
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j + 1);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
