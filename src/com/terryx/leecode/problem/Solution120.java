package com.terryx.leecode.problem;

import java.util.List;

/**
 * @author taoranxue on 10/20/16 7:04 PM.
 */
public class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.get(0) == null) return 0;
        int h = triangle.size();
        int w = triangle.get(h - 1).size();
        int f[] = new int[w + 1];
        for (int j = 0; j < w; ++j) {
            f[j] = triangle.get(h - 1).get(j);
        }
        for (int i = h - 2; i >= 0; --i) {
            for (int j = 0; j <= i; ++j) {
                f[j] = triangle.get(i).get(j) + Math.min(f[j], f[j + 1]);
            }
        }
        return f[0];
    }
}
