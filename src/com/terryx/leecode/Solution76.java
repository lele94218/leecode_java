package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/18/17 6:22 PM.
 */
public class Solution76 {
    public String minWindow(String s, String t) {
        int map[] = new int[256];
        for (int i = 0; i < t.length(); ++i) {
            map[t.charAt(i)]++;
        }
        int begin = 0, end = 0, len = Integer.MAX_VALUE, head = 0, count = t.length();
        for (; end < s.length(); end++) {
            if (map[s.charAt(end)]-- > 0) count--;
            while (count == 0) {
                if (end - begin + 1 < len) {
                    len = end - begin + 1;
                    head = begin;
                }
                if (map[s.charAt(begin)]++ == 0) count++;
                begin++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(head, head + len);
    }
}
