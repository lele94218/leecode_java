package com.terryx.leecode.contest42;

/**
 * @author taoranxue on 7/23/17 9:47 AM.
 */
public class Solution647 {
    public int countSubstrings(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        for (int i = 0; i < s.length(); ++i) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                int p = i;
                int q = i + 1;
                while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
                    res++;
                    p--;
                    q++;
                }
            }
            if (i + 2 < s.length() && s.charAt(i) == s.charAt(i + 2)) {
                int p = i;
                int q = i + 2;
                while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
                    res++;
                    p--;
                    q++;
                }
            }
        }
        return res + s.length();
    }
}
