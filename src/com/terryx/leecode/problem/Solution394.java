package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 6:35 PM.
 */
public class Solution394 {
    private int next = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || next >= s.length()) {
            return sb.toString();
        }
        int cnt = 0;
        while (next < s.length()) {
            char c = s.charAt(next);
            if (Character.isDigit(c)) {
                while (next < s.length() && Character.isDigit(s.charAt(next))) {
                    cnt = cnt * 10 + s.charAt(next++) - '0';
                }
            } else if (c == '[') {
                ++next;
                String tmp = decodeString(s);
                while (cnt > 0) {
                    sb.append(tmp);
                    cnt--;
                }
            } else if (c == ']') {
                ++next;
                return sb.toString();
            } else {
                sb.append(c);
                ++next;
            }
        }
        return sb.toString();
    }
}
