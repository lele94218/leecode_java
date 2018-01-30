package com.terryx.leecode.weeklycontest.contest65;

import java.util.*;

/**
 * @author taoranxue on 1/10/18 6:37 PM.
 */
public class Solution757 {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        int rb0 = -1, rb1 = -1, res = 0;
        for (int i = 0; i < intervals.length; ++i) {
            int[] interval = intervals[i];
            if (interval[0] > rb1) {
                res += 2;
                rb0 = interval[1] - 1;
                rb1 = interval[1];
            } else if (interval[0] > rb0) {
                res += 1;
                rb0 = rb1;
                if (interval[1] == rb1) {
                    rb0--;
                }
                rb1 = interval[1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution757 m = new Solution757();
        m.intersectionSizeTwo(new int[][]{{2, 10}, {3, 7}, {3, 15}, {4, 11}, {6, 12}, {6, 16}, {7, 8}, {7, 11}, {7, 15}, {11, 12}});
    }
}
