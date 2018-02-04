package com.terryx.leecode.problem;

import com.terryx.main.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author taoranxue on 8/3/17 5:19 PM.
 */
public class Solution56 {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 0) return new ArrayList<Interval>(0);
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b) {
                if (a.start != b.start) return a.start - b.start;
                return a.end - b.end;
            }
        });
        ArrayList<Interval> res = new ArrayList<>();

        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++ i) {
            if (cur.end >= intervals.get(i).start) {
                cur = new Interval(cur.start, Math.max(cur.end, intervals.get(i).end));
            } else {
                res.add(cur);
                cur = intervals.get(i);
            }
        }

        res.add(cur);
        return res;
    }
}
