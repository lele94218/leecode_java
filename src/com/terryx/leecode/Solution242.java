package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/19/17 12:00 AM.
 */
public class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            return true;
        }
        int cnt[] = new int[256];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); ++i) {
            cnt[t.charAt(i)]--;
        }
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
