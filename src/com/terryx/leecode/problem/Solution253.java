package com.terryx.leecode.problem;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 9/14/17 5:21 PM.
 */
public class Solution253 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Queue<Interval> queue = new PriorityQueue<>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        for (int i = 0; i < intervals.length; ++i) {
            if (!queue.isEmpty() && intervals[i].start >= queue.peek().end)
                queue.poll();
            queue.offer(intervals[i]);
        }
        return queue.size();
    }
}
