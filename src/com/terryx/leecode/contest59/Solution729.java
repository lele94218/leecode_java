package com.terryx.leecode.contest59;

import java.util.*;

/**
 * @author taoranxue on 1/29/18 5:57 PM.
 */
public class Solution729 {
    class MyCalendar {
        class Interval {
            int start, end;
            Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        List<Interval> list;
        public MyCalendar() {
            list = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            Interval newInterval = new Interval(start, end);
            for (Interval interval : list) {
                if (interval.start < newInterval.end && interval.end > newInterval.start) {
                    return false;
                }
            }
            list.add(newInterval);
            return true;
        }
    }
}
