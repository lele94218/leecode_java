package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/16/17 5:29 PM.
 */
public class SuperPow {
    static int mod = 1337;

    public int superPow(int a, int[] b) {
        if (b == null || b.length == 0) {
            return 1;
        }
        return helper(a, b, b.length - 1);
    }

    private int pow(int a, int b) {
        long res = 1;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = (res * a) % mod;
            }
            a = (a % mod) * (a % mod);
            b = b >>> 1;
        }
        return (int) res;
    }

    private int helper(int a, int[] b, int cur) {
        if (cur == 0) {
            return pow(a, b[cur]);
        }
        return (pow(helper(a, b, cur - 1), 10) * pow(a, b[cur])) % mod;
    }
}
