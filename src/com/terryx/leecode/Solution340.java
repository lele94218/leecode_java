package com.terryx.leecode;

import java.util.HashMap;

/**
 * @author taoranxue on 10/30/16 2:15 AM.
 */
public class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int map[] = new int[128];
        int begin = 0, end = 0, count = k, len = 0;
        for (; end < s.length(); end++) {
            if (map[s.charAt(end)]++ == 0) --count;
            while (count < 0) {
                if (map[s.charAt(begin)]-- == 1) ++count;
                begin++;
            }
            len = Math.max(len, end - begin + 1);
        }
        return len;
    }

    public int lengthOfLongestSubstringKDistinct1(String s, int k) {
        if (s.length() == 0) return 0;
        int low = 0, res = 0;
        HashMap<Character, Integer> rightMost = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            rightMost.put(s.charAt(i), i);
            if (rightMost.size() > k) {
                int leftMost = s.length();
                for (int ix : rightMost.values()) leftMost = Math.min(leftMost, ix);
                char c = s.charAt(leftMost);
                rightMost.remove(c);
                low = leftMost + 1;
            }
            res = Math.max(res, i - low + 1);
        }
        return res;
    }
}
