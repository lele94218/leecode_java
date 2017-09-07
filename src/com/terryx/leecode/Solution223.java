package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/7/17 2:07 PM.
 */
public class Solution223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int top = Math.min(H, D);
        int bottom = Math.max(B, F);
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        if (left < right && bottom < top) {
            total -= (right - left) * (top - bottom);
        }
        return total;
    }
}
