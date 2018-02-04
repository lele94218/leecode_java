package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/4/17 11:28 AM.
 */
public class Solution521 {
    public int findLUSlength(String a, String b) {
        if (a == null || b == null) return -1;
        if (a.length() != b.length()) return Math.max(a.length(), b.length());
        int p = 0, q = 0;
        while (p < a.length() && a.charAt(p) == b.charAt(q)) {
            p++;
            q++;
            if (p == a.length()) return -1;
        }
        return a.length() == 0 ? -1 : a.length();
    }
}
