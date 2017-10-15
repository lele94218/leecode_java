package com.terryx.gwualgorithm.facebook;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 10/14/17 6:49 PM.
 */
public class MeetingRoom {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.end - b.end;
            }
        });
        Interval cur = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (cur.end > intervals[i].start) {
                return false;
            }
            cur = intervals[i];
        }
        return true;
    }

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
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
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            if (queue.peek().end <= intervals[i].start) {
                Interval tmp = queue.poll();
                tmp.end = intervals[i].end;
                queue.offer(tmp);
            } else {
                queue.offer(intervals[i]);
            }
        }
        return queue.size();
    }

    public int cntMaxMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int start[] = new int[intervals.length], end[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int cnt = 0, p = 0;
        for (int i = 0; i < intervals.length; ++i) {
            if (start[i] < end[p]) {
                cnt++;
            } else {
                p++;
            }
        }
        return cnt;
    }

    public List<Integer> cntMaxMeetingsTime(Interval[] intervals) {
        int start[] = new int[intervals.length], end[] = new int[intervals.length];
        for (int i = 0; i < intervals.length; ++i) {
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int p = 0, cnt = 0, max = 0, left = 0, right = 0;
        for (int i = 0; i < intervals.length; ++i) {
            if (start[i] < end[p]) {
                cnt++;
                if (max < cnt) {
                    max = cnt;
                    left = start[i];
                    right = end[p];
                }
            } else {
                while (start[i] >= end[++p]) {
                    cnt--;
                }
            }
        }
        return Arrays.asList(left, right);
    }
}
