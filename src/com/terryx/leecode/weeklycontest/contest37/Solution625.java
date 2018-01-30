package com.terryx.leecode.weeklycontest.contest37;

/**
 * @author taoranxue on 6/17/17 10:35 PM.
 */
public class Solution625 {
    int ret = Integer.MAX_VALUE;
    public int smallestFactorization(int a) {
        long res = a;
        dfs(a, 0);
        if (ret == Integer.MAX_VALUE) ret = 0;
        return ret;
    }

    public void dfs (int n, long res) {
        if (res > Integer.MAX_VALUE || (int) res < 0) {
            return;
        }
        if (n < 10) {
            res = res * 10 + n;
            System.out.println(res);
            if (res > Integer.MAX_VALUE || (int) res < 0) res = Integer.MAX_VALUE;
            ret = Math.min((int)res, ret);
            return;
        }
        for (int i = 2; i <= Math.min(9, (int)Math.sqrt(n)); ++ i) {
            if (n % i == 0) {
                long _res = res * 10 + i;
                dfs(n/i, _res);
            }
        }
    }

}

