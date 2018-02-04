package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/24/17 7:14 PM.
 */
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left >>> 1);
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                left = mid + 1;
            }
        }

    }
}
