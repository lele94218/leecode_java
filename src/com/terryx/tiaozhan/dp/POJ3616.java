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
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            }
        });

        int dp[] = new int[m];
        for (int i = 0; i < m; ++ i) {
            dp[i] = intervals[i].value;
            for (int j = 0; j < i; ++ j) {
                if (intervals[j].end + r <= intervals[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + intervals[i].value);
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }

        System.out.println(dp[m - 1]);
    }
}
