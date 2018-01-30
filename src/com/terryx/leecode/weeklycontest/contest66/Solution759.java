package com.terryx.leecode.weeklycontest.contest66;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 1/6/18 9:58 PM.
 */
public class Solution759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        if (avails == null || avails.size() == 0) {
            return new ArrayList<>();
        }

        List<Interval> res = new ArrayList<>();

        for (List<Interval> list : avails) {
            for (Interval interval : list) {
                res.add(interval);
            }
        }

        Collections.sort(res, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });

        Interval tmp = res.get(0);
        List<Interval> merge = new ArrayList<>();
        for (int i = 1; i < res.size(); ++i) {
            if (tmp.end >= res.get(i).start) {
                tmp.end = Math.max(tmp.end, res.get(i).end);
            } else {
                merge.add(tmp);
                tmp = res.get(i);
            }
        }
        merge.add(tmp);
        res = new ArrayList<>();
        for (int i = 0; i + 1 < merge.size(); ++i) {
            res.add(new Interval(merge.get(i).end, merge.get(i + 1).start));
        }
        return res;
    }
}
