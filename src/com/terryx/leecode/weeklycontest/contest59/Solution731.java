package com.terryx.leecode.weeklycontest.contest59;

import java.util.*;

/**
 * @author taoranxue on 1/29/18 6:09 PM.
 */
public class Solution731 {
    class MyCalendarTwo {
        class Interval {
            int start, end;
            List<Interval> intersects;

            Interval(int start, int end) {
                this.start = start;
                this.end = end;
                this.intersects = new ArrayList<>();
            }

            @Override
            public String toString() {
                return ("[" + start + "," + end + "]");
            }
        }

        List<Interval> list = new ArrayList<>();

        public MyCalendarTwo() {

        }

        public boolean book(int start, int end) {
            Interval newInterval = new Interval(start, end);
            for (Interval interval : list) {
                if (interval.start < newInterval.end && interval.end > newInterval.start) {
                    for (Interval in : interval.intersects) {
                        if (in.start < newInterval.end && in.end > newInterval.start) {
                            return false;
                        }
                    }
                }
            }

            for (Interval interval : list) {
                if (interval.start < newInterval.end && interval.end > newInterval.start) {
                    Interval tmp = new Interval(Math.max(start, interval.start), Math.min(end, interval.end));
                    interval.intersects.add(tmp);
                    newInterval.intersects.add(tmp);
                }
            }
            list.add(newInterval);
            //System.out.println(list);
            return true;
        }
    }

    public static void main(String[] args) {
        //[36,41],[28,34],[40,46],[10,18],[4,11],[25,34],[36,44],[32,40],[34,39],[40,49]]
        Solution731 m = new Solution731();
        Solution731.MyCalendarTwo c = m.new MyCalendarTwo();
        System.out.println(c.book(36, 41));
        System.out.println(c.book(28, 34));
        System.out.println(c.book(40, 46));
        System.out.println(c.book(10, 18));
        System.out.println(c.book(4, 11));
        System.out.println(c.book(25, 34));
        System.out.println(c.book(36, 44));
        System.out.println(c.book(32, 40));
        System.out.println(c.book(34, 39));
        System.out.println(c.book(40, 49));
    }
}
