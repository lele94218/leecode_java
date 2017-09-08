package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/7/17 7:30 PM.
 */
public class Solution396 {
    public int maxRotateFunction(int[] A) {
        int f = 0, sum = 0;
        for (int i = 0; i < A.length; ++i) {
            f += i * A[i];
            sum += A[i];
        }
        int res = f;
        for (int i = 1; i < A.length; ++i) {
            f = f + sum - A.length * A[A.length - i];
            res = Math.max(res, f);
        }
        return res;
    }
}
