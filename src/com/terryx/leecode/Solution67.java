package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/14/17 3:10 PM.
 */
public class Solution67 {
    public String addBinary(String a, String b) {
        if (a == null) a = "";
        if (b == null) b = "";
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        String res = "";
        while (i >= 0 || j >= 0 || c > 0) {
            int sum = 0;
            if (i >= 0 && j >= 0) {
                sum = a.charAt(i) - '0' + b.charAt(j) - '0' + c;
            } else if (i >= 0) {
                sum = a.charAt(i) - '0' + c;
            } else if (j >= 0) {
                sum = b.charAt(j) - '0' + c;
            } else {
                sum = c;
            }
            c = sum / 2;
            res = (char) (sum % 2 + '0') + res;
            --i;
            --j;
        }
        return res;
    }
}
