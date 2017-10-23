package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/22/17 3:06 PM.
 */
public class RemoveDigit {
    /**
     * 给两个数 n1, n2. n2 is n1 without 1 digit, e.g. n1 = 123,
     * then n2 can be 12, 13 or 23. 现在知道n1+n2的和是多少，
     * 求n1 和 n2 的可能值
     */
    public static Integer extractIfLast(int sum) {
        int small = sum / 11;
        int large = sum - small;
        if (large / 10 == small) return large;
        else return null;
    }

    public static void main(String[] args) {
        System.out.println(extractIfLast(123));
    }
}
