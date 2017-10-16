package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/15/17 7:59 PM.
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        return add(num1, num2, 10);
    }

    public String add(String a, String b, int radix) {
        if (a == null || b == null) {
            return "";
        }
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || c > 0) {
            int sum = (i >= 0 ? (a.charAt(i) - '0') : 0)
                    + (j >= 0 ? (b.charAt(j) - '0') : 0) + c;
            res.append((char) (sum % radix + '0'));
            c = sum / radix;
            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
