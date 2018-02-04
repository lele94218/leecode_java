package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/22/17 11:51 AM.
 */
public class Solution12 {
    public String intToRoman(int num) {
        int val[] = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String sym[] = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length; ++i) {
            if (num == 0) break;
            if (num >= val[i]) {
                num -= val[i];
                sb.append(sym[i]);
                --i;
            }
        }
        return sb.toString();
    }
}
