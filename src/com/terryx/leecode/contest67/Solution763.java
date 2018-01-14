package com.terryx.leecode.contest67;

import java.util.*;

/**
 * @author taoranxue on 1/13/18 9:38 PM.
 */
public class Solution763 {
    static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        if (S == null) {
            return res;
        }

        List<Interval> intervals = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            char c = (char) ('a' + i);
            int start = S.indexOf(c);
            if (start != -1) {
                int end = start;
                while (end + 1 < S.length()) {
                    int tmp = S.indexOf(c, end + 1);
                    if (tmp == -1) {
                        break;
                    }
                    end = tmp;
                }

                intervals.add(new Interval(start, end));
            }
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });
        List<Interval> merge = new ArrayList<>();
        Interval cur = intervals.get(0);
        for (int i = 1; i < intervals.size(); ++ i) {
            if (cur.end >= intervals.get(i).start) {
                cur.end = Math.max(cur.end, intervals.get(i).end);
            } else {
                merge.add(cur);
                cur = intervals.get(i);
            }
        }
        merge.add(cur);

        for (Interval interval : merge) {
            res.add(interval.end - interval.start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution763 m = new Solution763();
        System.out.println(m.partitionLabels("acbcccc"));
    }
}
