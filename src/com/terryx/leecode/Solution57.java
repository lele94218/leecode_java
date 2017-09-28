package com.terryx.leecode;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 9/20/17 4:35 PM.
 */
public class Solution57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || intervals == null) return intervals;
        int index = 0;
        List<Interval> ans = new ArrayList<>();
        while (index < intervals.size() && intervals.get(index).end < newInterval.start) {
            ans.add(intervals.get(index++));
        }
        Interval cur = new Interval(newInterval.start, newInterval.end);
        while (index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            cur.start = Math.min(cur.start, intervals.get(index).start);
            cur.end = Math.max(cur.end, intervals.get(index).end);
            index++;
        }
        ans.add(cur);
        while (index < intervals.size()) ans.add(intervals.get(index++));
        return ans;
    }

    public List<Interval> insert1(List<Interval> intervals, Interval newInterval) {
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
