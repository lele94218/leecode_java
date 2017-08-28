package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/29/17 12:09 AM.
 */
public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n > 10) return 0;
        int res = 10, t = 9;
        for (int i = 1; i < n; ++i) {
            t *= (10 - i);
            res += t;
        }
        return res;
    }
}
