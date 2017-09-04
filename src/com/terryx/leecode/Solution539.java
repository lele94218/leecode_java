package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/4/17 5:59 PM.
 */
public class Solution539 {
    public int findMinDifference(List<String> timePoints) {
        if (timePoints == null || timePoints.size() == 0) return 0;
        boolean bucket[] = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] num = time.split(":");
            int cov = Integer.parseInt(num[0]) * 60 + Integer.parseInt(num[1]);
            if (bucket[cov]) return 0;
            bucket[cov] = true;
        }
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE, prev = 0, res = Integer.MAX_VALUE;
        for (int i = 0; i < 24 * 60; ++i) {
            if (bucket[i]) {
                if (first != Integer.MAX_VALUE)
                    res = Math.min(res, i - prev);
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        // System.out.println(first + " " + last + ": " + res);
        return Math.min(res, 24 * 60 - (last - first));
    }
}
