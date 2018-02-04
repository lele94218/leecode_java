package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/1/17 12:36 PM.
 */
public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        long div = Math.abs((long) dividend), dis = Math.abs((long) divisor), res = 0;
        while (div >= dis) {
            long tmp = dis, cnt = 1;
            while (div >= (tmp << 1)) {
                tmp <<= 1;
                cnt <<= 1;
            }
            div -= tmp;
            res += cnt;
        }
        return (int) (sign * res);
    }
}
