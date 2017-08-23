package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/23/17 12:56 PM.
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) return "";
        int res[] = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; --i) {
            for (int j = num2.length() - 1; j >= 0; --j) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + res[i + j + 1];
                res[i + j] += mul / 10;
                res[i + j + 1] = mul % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < res.length && res[i] == 0) {
            ++i;
        }
        for (; i < res.length; ++i) {
            sb.append(res[i]);
        }
        if (sb.length() == 0) sb.append("0");
        return sb.toString();
    }
}
