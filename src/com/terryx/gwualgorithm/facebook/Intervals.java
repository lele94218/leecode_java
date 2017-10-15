package com.terryx.gwualgorithm.facebook;

import com.terryx.main.Interval;

import java.util.*;

/**
 * @author taoranxue on 10/14/17 3:42 PM.
 */
public class Intervals {
    static class Interval2D {
        public int x0, y0, x1, y1;
        public double k, slope;

        Interval2D(int x0, int y0, int x1, int y1) {
            this.x0 = x0;
            this.y0 = y0;
            this.x1 = x1;
            this.y1 = y1;
            this.slope = calSlope(this);
            this.k = calK(this, this.slope);
        }

        private double calSlope(Interval2D interval) {
            if (interval.x0 == interval.x1) {
                return Double.MAX_VALUE;
            }
            return (double) (interval.y0 - interval.y1) / (interval.x0 - interval.x1);
        }

        private double calK(Interval2D interval, double slope) {
            if (slope == Double.MAX_VALUE) {
                return Double.MIN_VALUE;
            }
            return (double) interval.y0 - (double) interval.x0 * slope;
        }

        @Override
        public String toString() {
            return "(" + x0 + "," + y0 + ") (" + x1 + "," + y1 + ")";
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return ans;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++i) {
            if (cur.end >= intervals.get(i).start) {
                cur.end = Math.max(cur.end, intervals.get(i).end);
            } else {
                ans.add(cur);
                cur = intervals.get(i);
            }
        }
        ans.add(cur);
        return ans;
    }


    public List<Interval2D> merge2D(List<Interval2D> intervals) {
        List<Interval2D> ans = new ArrayList<>();
        if (intervals == null) return ans;
        Collections.sort(intervals, new Comparator<Interval2D>() {
            @Override
            public int compare(Interval2D a, Interval2D b) {
                if (Math.abs(a.slope - b.slope) < 1e-8) {
                    if (Math.abs(a.k - b.k) < 1e-8) {
                        return a.x0 - b.x0;
                    }
                    return a.k - b.k < 0 ? -1 : 1;
                }
                return a.slope - b.slope < 0 ? -1 : 1;
            }
        });
        Interval2D cur = intervals.get(0);
        for (Interval2D interval : intervals) {
            if (Math.abs(cur.k - interval.k) < 1e-8 && Math.abs(cur.slope - interval.slope) < 1e-8
                    && Math.abs(cur.x1) >= Math.abs(interval.x0)) {
                if (Math.abs(cur.x1) < Math.abs(interval.x1)) {
                    cur.x1 = interval.x1;
                    cur.y1 = interval.y1;
                }
            } else {
                ans.add(cur);
                cur = interval;
            }
        }
        ans.add(cur);
        return ans;
    }


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null || newInterval == null) return intervals;
        List<Interval> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size(); ++i) {
            Interval curInterval = intervals.get(i);
            if (newInterval == null || newInterval.start > curInterval.end) {
                ans.add(curInterval);
            } else if (newInterval.end < curInterval.start) {
                ans.add(newInterval);
                newInterval = null;
                ans.add(curInterval);
            } else {
                newInterval.start = Math.min(newInterval.start, curInterval.start);
                newInterval.end = Math.max(newInterval.end, curInterval.end);
            }
        }
        if (newInterval != null) {
            ans.add(newInterval);
        }
        return ans;
    }


    /**
     * 给一组区级的二维数组，每一组代表一个接收方，每一个接收方有一组区间。
     * 然后给一个整数，要求找出所有区间包含这个整数的接收方
     * <p>
     * 例子就是
     * A想要接收[1,4], [7,9], [12,15]
     * B想要接收[2,8], [10,12]
     * C想要接收[5,6]
     * <p>
     * 如果给一个数字8，应该返回A和B
     * 如果给个数字5，应该返回B和C
     */
    public List<Integer> findIntervalReceiver(List<List<Interval>> intervals, int target) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < intervals.size(); ++ i) {
            List<Interval> array = intervals.get(i);
            int left = 0, right = array.size() - 1, mid = 0;
            while (left <= right) {
                mid = left + (right - left >> 1);
                Interval midInterval = array.get(mid);
                if (midInterval.start <= target && target <= midInterval.end) {
                    ans.add(i);
                    break;
                }
                if (target < midInterval.start) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Intervals i = new Intervals();

        List<Interval2D> intervals = new ArrayList<>();
        intervals.add(new Interval2D(1, 0, 2, 0));
        intervals.add(new Interval2D(2, 0, 2, 1));
        intervals.add(new Interval2D(0, 0, 1, 1));
        intervals.add(new Interval2D(1, 1, 2, 2));
        intervals.add(new Interval2D(0, -1, 2, 3));
        List<Interval2D> ans1 = i.merge2D(intervals);
        System.out.println(ans1);

        List<List<Interval>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        lists.get(0).add(new Interval(1,4));
        lists.get(0).add(new Interval(7,9));
        lists.get(0).add(new Interval(12,15));
        lists.add(new ArrayList<>());
        lists.get(1).add(new Interval(2,8));
        lists.get(1).add(new Interval(10,12));
        lists.add(new ArrayList<>());
        lists.get(2).add(new Interval(5,6));
        List<Integer> ans2 = i.findIntervalReceiver(lists, 8);
        System.out.println(ans2);
        ans2 = i.findIntervalReceiver(lists, 5);
        System.out.println(ans2);
    }

}
