package com.terryx.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taoranxue on 8/17/17 2:45 PM.
 */
public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";
        StringBuilder res = new StringBuilder();
        int f0 = (numerator < 0) ? 1 : 0, f1 = (denominator < 0) ? 1 : 0;
        int neg = (numerator != 0) ? f0 ^ f1 : 0;
        if (neg == 1) res.append("-");

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        // System.out.println(num + " " + den);

        res.append(num / den);

        num %= den;

        if (num == 0) return res.toString();

        res.append(".");

        Map<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());

        while (num != 0) {
            num *= 10;
            res.append(num / den);
            num %= denominator;
            if (map.get(num) != null) {
                res.insert(map.get(num), "(");
                res.append(")");
                break;
            } else {
                map.put(num, res.length());
            }

        }
        return res.toString();
    }
}
