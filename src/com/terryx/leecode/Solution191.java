package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/28/17 10:52 AM.
 */
public class Solution191 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += (n & 1) != 0 ? 1 : 0;
            n >>>= 1;
        }
        return res;
    }
}
