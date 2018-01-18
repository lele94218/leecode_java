package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 3:32 PM.
 */
public class Solution686 {
    public int repeatedStringMatch(String A, String B) {
        if (A == null || B == null) {
            return -1;
        }
        StringBuilder sb = new StringBuilder();
        int res = 0;
        while (sb.length() < B.length()) {
            sb.append(A);
            res++;
        }

        if (sb.toString().contains(B)) return res;
        if (sb.append(A).toString().contains(B)) return res + 1;
        return -1;
    }
}
