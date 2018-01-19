package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 7:21 PM.
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        digits[digits.length - 1] += 1;
        int c = 0, index = digits.length - 1;
        while (index >= 0) {
            //System.out.println(index + " " + c);
            int t = (index >= 0 ? digits[index] : 0) + c;
            digits[index--] = t % 10;
            c = t / 10;

            if (c == 0) {
                return digits;
            }

        }

        int res[] = new int[digits.length + 1];
        res[0] = c;
        return res;
    }
}
