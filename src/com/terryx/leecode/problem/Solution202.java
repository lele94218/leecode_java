package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 11/1/17 9:14 PM.
 */
public class Solution202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            int res = 0;
            while (n != 0) {
                res += (n % 10) * (n % 10);
                n /= 10;
            }
            if (res == 1) {
                return true;
            }
            n = res;
        }
        return false;
    }
}
