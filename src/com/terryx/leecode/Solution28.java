package com.terryx.leecode;

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
}
