package com.terryx.leecode;

/**
 * @author taoranxue on 6/1/17 7:57 PM.
 */
public class Solution231 {
    public boolean isPowerOfTwo(int n) {
        if (n < 0) return false;
        int cnt = 0;
        do {
            if ((n & 1) == 1) ++ cnt;
        } while ((n >>= 1) != 0);
        if (cnt == 1) return true;
        return false;
    }
}
