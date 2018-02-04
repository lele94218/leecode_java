package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/4/17 5:26 PM.
 */
public class Solution537 {
    public String complexNumberMultiply(String a, String b) {
        if (a == null || b == null) return "";
        int[] aNum = convert(a), bNum = convert(b);
        int[] res = new int[3];
        res[0] = aNum[0] * bNum[0];
        res[1] = aNum[0] * bNum[1] + aNum[1] * bNum[0];
        res[2] = aNum[1] * bNum[1];
        return (res[0] + (-1 * res[2])) + "+" + res[1] + "i";
    }

    private int[] convert(String str) {
        int i = 0, j = 0, a = 0, b = 0;
        for (; i < str.length() && str.charAt(i) != '+'; ++ i);
        a = Integer.parseInt(str.substring(0, i));
        for (j = i + 1; j < str.length() && str.charAt(j) != 'i'; ++ j);
        b = Integer.parseInt(str.substring(i + 1, j));
        return new int[]{a, b};
    }
}
