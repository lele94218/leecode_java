package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/28/18 8:25 PM.
 */
public class Solution668 {
    public int findKthNumber(int m, int n, int k) {
        int low = 1, high = m * n;
        while (low < high) {
            int mid = (low + high) >>> 1;
            int count = 0;
            for (int i = 1; i <= m; ++i) {
                count += Math.min(n, mid / i);
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
