package com.terryx.leecode.weeklycontest.contest55;

import java.util.*;

/**
 * @author taoranxue on 2/10/18 4:52 PM.
 */
public class Solution715 {class RangeModule {
    class Interval {
        int start, end;
        Interval (int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return ("[" + start + ", " + end + "]");
        }

    }
    TreeSet<Interval> set;
    public RangeModule() {
        set = new TreeSet<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.end != b.end) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });
    }

    public void addRange(int left, int right) {
        // System.out.println("add: " + (new Interval(left, right)).toString());
        Iterator<Interval> itr = set.tailSet(new Interval(0, left)).iterator();
        while (itr.hasNext()) {
            Interval cur = itr.next();
            if (right < cur.start) {
                break;
            }
            left = Math.min(left, cur.start);
            right = Math.max(right, cur.end);
            itr.remove();
        }
        set.add(new Interval(left, right));
        // System.out.println(set);
    }

    public boolean queryRange(int left, int right) {
        // System.out.println("query: " + (new Interval(left, right)).toString());
        Interval res = set.higher(new Interval(0, left));
        // System.out.println(set);
        return (res != null && res.end >= right && res.start <= left);
    }

    public void removeRange(int left, int right) {
        // System.out.println("remove: " + (new Interval(left, right)).toString());
        Iterator<Interval> itr = set.tailSet(new Interval(0, left)).iterator();
        List<Interval> list = new ArrayList<>();
        while (itr.hasNext()) {
            Interval cur = itr.next();
            if (right < cur.start) {
                break;
            }
            if (left > cur.start) {
                list.add(new Interval(cur.start, left));
            }
            if (cur.end > right) {
                list.add(new Interval(right, cur.end));
            }
            itr.remove();
        }
        for (Interval interval : list) {
            set.add(interval);
        }
        // System.out.println(set);
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
}
