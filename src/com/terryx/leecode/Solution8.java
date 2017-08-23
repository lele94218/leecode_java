package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/19/17 11:01 PM.
 */
public class Solution8 {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        long neg = 1;
        int i = 0, len = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            ++i;
        }

        if (str.charAt(i) == '-') {
            neg = -1;
            ++i;
        } else if (str.charAt(i) == '+') {
            ++i;
        }

        long res = 0;
        for (; i < str.length(); ++i, ++len) {
            if (!Character.isDigit(str.charAt(i)) || len > 10) break;
            res = res * 10 + str.charAt(i) - '0';
        }
        res *= neg;
        if (res > Integer.MAX_VALUE) res = Integer.MAX_VALUE;
        else if (res < Integer.MIN_VALUE) res = Integer.MIN_VALUE;
        return (int) res;
    }
}
