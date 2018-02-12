package com.terryx.leecode.problem;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 2/10/18 6:08 PM.
 */
public class Solution352 {
    class SummaryRanges {
        TreeSet<Interval> set;
        /** Initialize your data structure here. */
        public SummaryRanges() {
            set = new TreeSet<>(new Comparator<Interval>(){
                public int compare(Interval a, Interval b) {
                    if (a.end != b.end) {
                        return a.end - b.end;
                    }
                    return a.start - b.start;
                }
            });
        }

        public void addNum(int val) {
            Iterator<Interval> itr = set.tailSet(new Interval(0, val - 1)).iterator();
            int start = val, end = val;
            while (itr.hasNext()) {
                Interval cur = itr.next();
                if (val + 1 < cur.start) {
                    break;
                }
                start = Math.min(start, cur.start);
                end = Math.max(end, cur.end);
                itr.remove();
            }
            set.add(new Interval(start, end));
        }

        public List<Interval> getIntervals() {
            return new ArrayList<>(set);
        }
    }
}
