package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/16/17 6:19 PM.
 */
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = dividend < 0 ^ divisor < 0;
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor);
        int res = 0;
        while (a >= b) {
            long tmp = b;
            int cnt = 0;
            while (a >= tmp) {
                tmp = tmp << 1;
                cnt++;
            }
            a -= (tmp >>> 1);
            res = res | (1 << (cnt - 1));
        }
        // if need remainder divisor < 0 ^ divisor < 0 ^ dividend < 0 -> dividend < 0
        System.out.println(dividend < 0 ? -a : a);
        return sign ? -res : res;
    }
}
