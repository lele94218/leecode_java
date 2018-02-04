package com.terryx.leecode.problem;

/**
 * @author taoranxue on 8/10/17 4:47 PM.
 */
public class Solution495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries == null || timeSeries.length == 0) return 0;
        int res = duration, cur = timeSeries[0] + duration - 1;
        for (int i = 1; i < timeSeries.length; ++i) {
            if (cur < timeSeries[i]) {
                res += duration;
            } else {
                res += (timeSeries[i] + duration - 1 - cur);
            }
            cur = timeSeries[i] + duration - 1;
        }
        return res;
    }
}
