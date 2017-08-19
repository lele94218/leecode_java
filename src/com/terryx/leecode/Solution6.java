package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/19/17 6:42 PM.
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) return "";
        if (numRows == 1 || numRows > s.length()) return s;
        StringBuilder sb = new StringBuilder();
        int len = (numRows - 1) * 2, start = 0;
        for (int i = 0; i <= len; i += 2) {
            sb.append(s.charAt(start));
            int idx = start;
            while (idx < s.length()) {
                if (idx + (len - i) >= s.length()) break;
                if (idx + (len - i) != idx) {
                    sb.append(s.charAt(idx + (len - i)));
                }
                idx += (len - i);

                if (idx + i >= s.length()) break;
                if (idx + i != idx) {
                    sb.append(s.charAt(idx + i));
                }
                idx += i;
            }
            start++;
        }
        return sb.toString();
    }
}
