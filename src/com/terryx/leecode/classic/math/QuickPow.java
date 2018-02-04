package com.terryx.leecode.classic.math;

/**
 * @author taoranxue on 9/30/17 2:32 PM.
 */
public class QuickPow {
    public long powerIter(int a, int b) {
        long res = 1, la = (long) a;
        while (b != 0) {
            if ((b & 1) == 1) {
                res = res * la;
            }
            la = la * la;
            b >>>= 1;
        }
        return res;
    }

    public long powerRecur(int a, int b) {
        if (b == 0) return 1;
        long half = powerRecur(a, b / 2);
        return b % 2 == 0 ? half * half : half * half * a;
    }
}
