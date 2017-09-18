package com.terryx.leecode;

import java.util.HashMap;

/**
 * @author taoranxue on 8/12/17 9:38 AM.
 */
public class Solution3 {
//    public int lengthOfLongestSubstring(String s) {
//        if (s == null || s.length() == 0) return 0;
//        int res = 0;
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0, j = 0; j < s.length(); ++j) {
//            if (map.containsKey(s.charAt(j))) {
//                // System.out.println("ok");
//                i = Math.max(i, map.get(s.charAt(j)));
//            }
//            map.put(s.charAt(j), j + 1);
//            res = Math.max(res, j - i + 1);
//        }
//        return res;
//    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int map[] = new int[128];
        int count = 0, begin = 0, end = 0, len = 0;
        for (; end < s.length(); ++ end) {
            if (map[s.charAt(end)]++ > 0) count++;
            while (count > 0) {
                if (map[s.charAt(begin)]-- > 1) count--;
                begin ++;
            }
            if (count == 0) len = Math.max(len, end - begin + 1);
        }
        return len;
    }
}
