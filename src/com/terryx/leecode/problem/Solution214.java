package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 3/2/18 3:31 PM.
 */
public class Solution214 {
    // O(n) KMP
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        int n = s.length();
        int f[] = new int[n];
        f[0] = 0;
        for (int i = 1; i < n; ++ i) {
            int t = f[i - 1];
            while (t > 0 && s.charAt(t) != s.charAt(i)) t = f[t - 1];
            if (s.charAt(t) == s.charAt(i)) ++t;
            f[i] = t;
        }
        String rs = (new StringBuilder(s)).reverse().toString();
        int i = 0;
        for (; i < n; ++ i) {
            boolean flag = true;
            int index = i;
            for (int j = 0; j < n - i; ++ j) {
                if (s.charAt(j) != rs.charAt(index)) {
                    i += f[j];
                    flag = false;
                    break;
                }
                index++;
            }
            if (flag) break;
        }
        return rs + s.substring(n - i, n);
    }
}
