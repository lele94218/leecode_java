package com.terryx.leecode.contest39;

/**
 * @author taoranxue on 7/1/17 9:30 PM.
 */
public class Solution633 {
    public static boolean judgeSquareSum(int c) {
        for (int i = 0; i <= Math.sqrt(c); ++i) {
            if ((double) Math.sqrt(c - i * i) - (int) Math.sqrt(c - i * i) == 0.0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(judgeSquareSum(0));
    }
}
