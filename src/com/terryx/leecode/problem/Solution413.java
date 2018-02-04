package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/31/17 8:40 AM.
 */
public class Solution413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int cur = 0, res = 0;
        for (int i = 2; i < A.length; ++i) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cur += 1;
                res += cur;
            } else {
                cur = 0;
            }
        }
        return res;
    }
}
