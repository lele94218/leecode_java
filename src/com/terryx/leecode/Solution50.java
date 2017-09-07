package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/7/17 12:34 PM.
 */
public class Solution50 {
    // iterative
    // public double myPow(double x, int n) {
    //     boolean sign = false;
    //     if (n < 0) {
    //         n = -n;
    //         sign = true;
    //     }
    //     double res = 1.0;
    //     while (n != 0) {
    //         if ((n & 1) == 1) {
    //             res *= x;
    //         }
    //         x *= x;
    //         n >>>= 1;
    //     }
    //     if (!sign) {
    //         return res;
    //     } else {
    //         return (1.0 / res);
    //     }
    // }

    // recursive
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) {
            n = -n;
            x = 1.0 / x;
        }
        if ((n & 1) == 1) {
            return x * myPow(x, n - 1);
        } else {
            double ret = myPow(x, n >>> 1);
            return ret * ret;
        }
    }
}
