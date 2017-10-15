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

    static class Rect {
        int x0, y0, x1, y1;

        Rect(int x0, int y0, int x1, int y1) {
            this.x0 = x0;
            this.y0 = y0;
            this.x1 = x1;
            this.y1 = y1;
        }
    }

    /**
     * 几何算法问题。如果给你一堆的矩形， 求重合矩形重合最多的坐标位置。
     * 我上过一个算法课，大概思路就是做一个二维的meeting room II。 扫描线算法。
     */
    public int cnt2DMaxMeetings(Rect[] intervals) {
        int res = 0;
        for (Rect rect : intervals) {
            res = Math.max(cnt1DMaxMeetings(intervals, rect.x0), res);
        }
        return res;
    }

    private int cnt1DMaxMeetings(Rect[] intervals, int target) {
        List<Integer> begin = new ArrayList<>(), end = new ArrayList<>();
        for (Rect rect : intervals) {
            if (rect.x0 <= target && target <= rect.x1) {
                begin.add(rect.y0);
                end.add(rect.y1);
            }
        }
        Collections.sort(begin);
        Collections.sort(end);
        int p = 0, cnt = 0, res = 0;
        for (int i = 0; i < begin.size(); ++ i) {
            if (begin.get(i) <= end.get(p)) {
                cnt++;
                res = Math.max(res, cnt);
            } else {
                while (begin.get(i) > end.get(p)) {
                    p++;
                    cnt--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MeetingRoom i = new MeetingRoom();
        Rect[] intervals = new Rect[3];
        intervals[0] = new Rect(0,0,1,1);
        intervals[1] = new Rect(0,0,2,2);
        intervals[2] = new Rect(1,1,3,3);
        System.out.println(i.cnt2DMaxMeetings(intervals));
    }
}
