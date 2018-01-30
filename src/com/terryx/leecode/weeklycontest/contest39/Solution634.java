package com.terryx.leecode.weeklycontest.contest39;

/**
 * @author taoranxue on 7/1/17 10:14 PM.
 */
public class Solution634 {
    public static int findDerangement(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        long prev = 1;
        long prprev = 0;
        long mod = 1000000007;
        long res = 0;
        for (int i = 3; i <= n; ++i) {
//            System.out.println(prprev + " " + prev);
            res = (i - 1) * (prev + prprev);
            res = (res + mod) % mod;
            prprev = prev;
            prev = res;
        }
        return (int)res;
    }
    public static void main(String args[]) {
        System.out.println(findDerangement(13));
    }

}
