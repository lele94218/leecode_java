package com.terryx.leecode.weeklycontest.contest42;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author taoranxue on 7/23/17 9:41 AM.
 */
public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int[] cur = pairs[0];
        int res = 1;
        for (int i = 1; i < pairs.length; ++i) {
            if (cur[1] < pairs[i][0]) {
                cur = pairs[i];
                res ++;
            }
        }
        return res;
    }
}
