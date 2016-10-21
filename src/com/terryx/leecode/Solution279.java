package com.terryx.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taoranxue on 10/20/16 8:50 PM.
 */
public class Solution279 {
    public int numSquares(int n) {
        int d[] = new int[n + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for (int i = 1; i * i <= n; ++i) {
            for (int j = i * i; j <= n; ++j) {
                d[j] = Math.min(d[j], d[j - i * i] + 1);
            }
        }
        return d[n];
    }
}
