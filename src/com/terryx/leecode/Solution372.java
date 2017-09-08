package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/7/17 7:06 PM.
 */
public class Solution372 {
    public int superPow(int a, int[] b) {
        return powHelper(a, b, b.length - 1);
    }

    private int pow(int a, int n) {
        int mod = 1337, res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res = (res * (a % mod)) % mod;
            }
            a = (a % mod) * (a % mod) % mod;
            n >>>= 1;
        }
        return res;
    }

    private int powHelper(int a, int[] b, int cur) {
        if (cur < 0) return 1;
        int digit = b[cur];
        return pow(powHelper(a, b, cur - 1), 10) * pow(a, digit) % 1337;
    }
}
