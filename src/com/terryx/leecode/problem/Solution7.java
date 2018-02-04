package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/31/17 4:25 PM.
 */
public class Solution7 {
    public int reverse(int x) {
        long num = (long) x, res = 0, flag = 1;
        if (num < 0) {
            num = -num;
            flag = -1;
        }
        while (num > 0) {
            long a = num % 10;
            res = res * 10 + a;
            num /= 10;
        }
        res *= flag;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }
}
