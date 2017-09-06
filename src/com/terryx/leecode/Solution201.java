package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/6/17 1:04 PM.
 */
public class Solution201 {
    public int rangeBitwiseAnd(int m, int n) {
        int cnt = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            cnt++;
        }
        return (m << cnt);
    }
}
