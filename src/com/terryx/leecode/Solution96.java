package com.terryx.leecode;

/**
 * @author taoranxue on 10/20/16 6:35 PM.
 */
public class Solution96 {
    public int numTrees(int n) {
        int G[] = new int[n + 1];
        G[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += (G[j - 1] * G[i - j]);
            }
        }
        return G[n];
    }
}
