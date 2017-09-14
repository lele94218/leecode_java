package com.terryx.leecode;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 9/14/17 4:43 PM.
 */
public class Solution252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        for (int i = 1; i < intervals.length; ++i) {
            if (intervals[i - 1].end > intervals[i].start) return false;
        }
        return true;
    }
}
