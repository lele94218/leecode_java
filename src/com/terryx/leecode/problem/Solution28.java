package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/1/17 12:11 PM.
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            int j = 0;
            for (; j < needle.length(); ++j) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) return i;
        }
        return -1;
    }

    // KMP
    public int strStr0(String s, String p) {
        if (p == null || p.length() > s.length()) return -1;
        if (p.length() == 0) return 0;
        int f[] = new int[p.length()];
        for (int i = 1; i < p.length(); ++i) {
            int t = f[i - 1];
            while (t > 0 && p.charAt(i) != p.charAt(t)) t = f[t - 1];
            if (p.charAt(i) == p.charAt(t)) ++t;
            f[i] = t;
        }

        for (int i = 0; i <= s.length() - p.length(); ++ i) {
            int index = i;
            boolean flag = true;
            for (int j = 0; j < p.length(); ++j) {
                if (s.charAt(index) != p.charAt(j)) {
                    i += f[j];
                    flag = false;
                    break;
                }
                index++;
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
