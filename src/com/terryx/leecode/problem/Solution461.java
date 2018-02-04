package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/24/17 7:06 PM.
 */
public class Solution461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
        // int cnt = 0;
        // while (x > 0 || y > 0) {
        //     cnt += Math.abs((x&1) - (y&1));
        //     x = x >>> 1;
        //     y = y >>> 1;
        // }
        // return cnt;
    }
}
