package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/19/17 12:50 PM.
 */
public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) return 0;
        int res = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0, n = 0;
            for (int i = 0; i < list.size() - 1; ++i) {
                n = list.get(i);
                sum += n;
                Integer v = map.get(sum);
                if (v != null) {
                    map.put(sum, v + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        for (Integer key : map.keySet()) {
            // System.out.println(map.get(key));
            res = Math.min(res, wall.size() - map.get(key));
        }
        return res;
    }
}
