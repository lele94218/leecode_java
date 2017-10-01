package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/30/17 6:52 PM.
 */
public class KthProblem {
    /**
     * Given two sorted arrays of integers, find the Kth smallest number.
     * Assumptions
     * The two given arrays are not null and at least one of them is not empty
     * K >= 1, K <= total lengths of the two sorted arrays
     * <p>
     * Examples
     * A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
     * A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
     *
     * @param a
     * @param b
     * @param k
     * @return
     */
    public int kthSmallestOfTwoArrays(int a[], int b[], int k) {
        return helper(a, 0, b, 0, k);
    }

    private int helper(int a[], int aleft, int b[], int bleft, int k) {
        if (aleft == a.length) {
            return b[bleft + k - 1];
        }
        if (bleft == b.length) {
            return a[aleft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }
        int amid = aleft + k / 2 - 1, bmid = bleft + k / 2 - 1;
        int aval = amid < a.length ? a[amid] : Integer.MAX_VALUE;
        int bval = bmid < b.length ? b[bmid] : Integer.MAX_VALUE;
        if (aval <= bval) {
            return helper(a, amid + 1, b, bleft, k - k / 2);
        } else {
            return helper(a, aleft, b, bmid + 1, k - k / 2);
        }
    }
}
