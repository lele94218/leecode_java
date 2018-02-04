package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/19/17 4:53 PM.
 */
public class Solution161 {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        int sLen = s.length(), tLen = t.length();
        for (int i = 0; i < Math.min(sLen, tLen); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (sLen > tLen) {
                    return s.substring(i + 1, s.length()).equals(t.substring(i, t.length()));
                } else if (sLen < tLen) {
                    return s.substring(i, s.length()).equals(t.substring(i + 1, t.length()));
                } else {
                    return s.substring(i + 1, s.length()).equals(t.substring(i + 1, t.length()));
                }
            }
        }
        return Math.abs(sLen - tLen) == 1;
    }
}
