package com.terryx.leecode.contest39;

import java.util.*;

/**
 * @author taoranxue on 7/1/17 10:40 PM.
 */
public class Solution632 {
    static class Unit {
        int val, x, y;

        public Unit(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        if (nums == null || nums.size() == 0) return new int[0];
        int max = Integer.MIN_VALUE, len = Integer.MAX_VALUE, end = 0;
        Queue<Unit> queue = new PriorityQueue<>(new Comparator<Unit>() {
            public int compare(Unit a, Unit b) {
                return a.val - b.val;
            }
        });
        for (int i = 0; i < nums.size(); ++i) {
            int val = nums.get(i).get(0);
            max = Math.max(max, val);
            queue.offer(new Unit(val, i, 0));
        }
        while (queue.size() == nums.size()) {
            Unit tmp = queue.poll();
            if (max - tmp.val < len) {
                len = max - tmp.val;
                end = max;
            }
            int idx = tmp.y + 1;
            if (idx < nums.get(tmp.x).size()) {
                tmp.val = nums.get(tmp.x).get(idx);
                max = Math.max(max, tmp.val);
                tmp.y = idx;
                queue.offer(tmp);
            }
        }
        return new int[]{end - len, end};
    }
}
