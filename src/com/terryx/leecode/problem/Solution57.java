package com.terryx.leecode.problem;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 9/20/17 4:35 PM.
 */
public class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) return intervals;
        List<Interval> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size(); ++ i) {
            Interval curInterval = intervals.get(i);
            if (newInterval == null || newInterval.start > curInterval.end) {
                ans.add(curInterval);
            } else if (newInterval.end < curInterval.start) {
                ans.add(newInterval);
                newInterval = null;
                ans.add(curInterval);
            } else {
                newInterval.start = Math.min(newInterval.start, curInterval.start);
                newInterval.end = Math.max(newInterval.end, curInterval.end);
            }
        }
        if (newInterval != null) {
            ans.add(newInterval);
        }
        return ans;
    }
}
