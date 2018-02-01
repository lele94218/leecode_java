package com.terryx.interview.purestorage;

import java.util.*;

/**
 * @author taoranxue on 11/2/17 1:07 PM.
 */
public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        if (p1[0] == p2[0] && p1[1] == p2[1]
                || p1[0] == p3[0] && p1[1] == p3[1]
                || p1[0] == p4[0] && p1[1] == p4[1]) {
            return false;
        }
        int d2 = dist(p1, p2);
        int d3 = dist(p1, p3);
        int d4 = dist(p1, p4);
        if (d2 == d3 && 2 * d2 == d4) {
            return dist(p2, p4) == dist(p3, p4) && d4 == dist(p2, p3);
        }
        if (d3 == d4 && 2 * d3 == d2) {
            return dist(p3, p2) == dist(p4, p2) && d2 == dist(p3, p4);
        }
        if (d2 == d4 && 2 * d2 == d3) {
            return dist(p2, p3) == dist(p4, p3) && d3 == dist(p2, p4);
        }
        return false;
    }

    private int dist(int[] p, int q[]) {
        return (p[0] - q[0]) * (p[0] - q[0]) + (p[1] - q[1]) * (p[1] - q[1]);
    }

    public int findSquare(int[][] points) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int n = points.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int d = dist(points[i], points[j]);
                if (!map.containsKey(d)) {
                    map.put(d, new ArrayList<>());
                }
                map.get(d).add(new int[]{i, j});
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int d = dist(points[i], points[j]);
                if (map.containsKey(d)) {
                    List<int[]> list = map.get(d);
                    for (int idx = 0; i < list.size(); ++i) {
                        if (validSquare(points[i], points[j], points[list.get(idx)[0]], points[list.get(idx)[1]])) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
