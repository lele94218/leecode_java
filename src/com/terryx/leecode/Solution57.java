package com.terryx.leecode;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 9/20/17 4:35 PM.
 */
public class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null) return intervals;
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval cur = intervals.get(0);
        List<Interval> res = new ArrayList<>();
        for (int i = 1; i < intervals.size(); ++i) {
            if (cur.end >= intervals.get(i).start) {
                cur.end = Math.max(cur.end, intervals.get(i).end);
            } else {
                res.add(cur);
                cur = intervals.get(i);
            }
        }
        res.add(cur);
        return res;
    }
}
