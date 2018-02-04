package com.terryx.leecode.problem;

import java.util.HashMap;

/**
 * @author taoranxue on 10/30/16 1:01 AM.
 */
public class Solution159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) return 0;
        int map[] = new int[128];
        int begin = 0, end = 0, len = 0, count = 2;
        for (; end < s.length(); ++end) {
            if (map[s.charAt(end)]++ == 0) count--;
            while (count < 0) {
                if (map[s.charAt(begin)]-- == 1) count++;
                begin++;
            }
            len = Math.max(len, end - begin + 1);
        }
        return len;
    }

    public int lengthOfLongestSubstringTwoDistinct3(String s) {
        if (s.length() == 0) return 0;
        int low = 0, res = 0;
        HashMap<Character, Integer> rightMost = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            rightMost.put(s.charAt(i), i);
            if (rightMost.size() > 2) {
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


    public int lengthOfLongestSubstringTwoDistinct2(String s) {
        if (s.length() < 1) return 0;
        int left = 0, right = 0;
        int res = 0;
        HashMap<Character, Integer> index = new HashMap<>();
        while (right < s.length()) {
            if (index.size() <= 2) {
                char c = s.charAt(right);
                index.put(c, right);
                right++;
            }
            if (index.size() > 2) {
                int leftMost = s.length();
                for (int ix : index.values()) {
                    leftMost = Math.min(ix, leftMost);
                }
                char c = s.charAt(leftMost);
                index.remove(c);
                left = leftMost + 1;
            }
            System.out.println(left + " " + right);
            res = Math.max(res, right - left);
        }
        return res;
    }
}
