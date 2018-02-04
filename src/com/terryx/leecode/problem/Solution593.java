package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/8/17 1:18 PM.
 */
public class Solution593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] points = new int[][]{p1, p2, p3, p4};
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] p, int[] q) {
                if (p[0] == q[0]) return p[1] - q[1];
                return p[0] - q[0];
            }
        });
        return dist(points[0], points[1]) != 0 &&
                dist(points[0], points[1]) == dist(points[1], points[3]) &&
                dist(points[1], points[3]) == dist(points[3], points[2]) &&
                dist(points[3], points[2]) == dist(points[2], points[0]) &&
                dist(points[1], points[2]) == dist(points[0], points[3]);
    }

    private int dist(int[] p, int q[]) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }
}
