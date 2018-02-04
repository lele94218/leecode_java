package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/6/17 2:43 PM.
 */
public class Solution397 {
    public int integerReplacement(int n) {
        int res = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n >>>= 1;
            } else if (n == 3 || (n & 3) != 3) {
                n -= 1;
            } else {
                n += 1;
            }
            ++res;
        }
        return res;
    }
}
