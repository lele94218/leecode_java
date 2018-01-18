package com.terryx.tiaozhan.dp;

import java.util.*;

/**
 * @author taoranxue on 1/15/18 10:06 PM.
 */
public class POJ3616 {
    static class Interval {
        int start, end, value;

        Interval(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public String toString() {
            return ("[" + start + "," + end + "], " + value);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), r = in.nextInt();
        Interval intervals[] = new Interval[m];
        for (int i = 0; i < m; ++i) {
            int begin = in.nextInt(), end = in.nextInt(), value = in.nextInt();
            intervals[i] = new Interval(begin, end, value);
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.end == b.end) {
                    return a.start - b.start;
                }
                return a.end - b.end;
            }
        });

        int dp[] = new int[m];
        for (int i = 0; i < m; ++i) {
            dp[i] = intervals[i].value;
            for (int j = 0; j < i; ++j) {
                if (intervals[j].end + r <= intervals[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + intervals[i].value);
                } else {
                    // If we sort by begin time, we can't guarantee that dp[i] solution's ending time is smaller than
                    // future intervals.
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
// Input:
//        90 20 4
//        55 80 5
//        74 84 16
//        42 57 19
//        40 64 8
//        48 57 5
//        43 58 17
//        62 81 10
//        1 59 16
//        17 38 18
//        80 83 19
//        83 86 20
//        32 33 13
//        13 25 8
//        27 79 9
//        12 43 16
//        64 70 3
//        75 89 12
//        62 75 18
//        34 55 14
//        3 26 13
// Output:
//        83

        System.out.println(dp[m - 1]);
    }
}
