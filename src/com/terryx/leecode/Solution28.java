package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/1/17 12:11 PM.
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int k = 1;
                for (int j = i + 1; k < needle.length() && haystack.charAt(j) == needle.charAt(k); j++, k++) ;
                if (k == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
