package com.terryx.leecode;

/**
 * @author taoranxue on 10/17/16 9:25 PM.
 */
public class Solution70 {
    public int climbStairs(int n) {
        int f[] = new int[100010];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; ++i) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
