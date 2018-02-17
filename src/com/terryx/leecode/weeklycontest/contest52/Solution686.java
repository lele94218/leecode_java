package com.terryx.leecode.weeklycontest.contest52;

import java.util.*;

/**
 * @author taoranxue on 2/16/18 6:22 PM.
 */
public class Solution686 {
    public int repeatedStringMatch(String A, String B) {
        if (A == null || B == null) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 2 * B.length()) {
            sb.append(A);
        }
        int index = sb.toString().indexOf(B);
        if (index == -1) {
            return -1;
        } else {
            return (int)Math.ceil((double) (index + B.length()) / (double) A.length());
        }
    }

    public static void main(String[] args) {
        Solution686 m = new Solution686();
        System.out.println(m.repeatedStringMatch("abcd", "abcda"));
    }
}
