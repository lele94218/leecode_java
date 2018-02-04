package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/7/17 6:30 PM.
 */
public class Solution365 {

    // BFS solution
    // public boolean canMeasureWater(int x, int y, int z) {
    //     Set<Integer> set = new HashSet<>();
    //     Queue<Integer> queue = new LinkedList<>();
    //     queue.offer(0);
    //     while (!queue.isEmpty()) {
    //         int cur = queue.poll();
    //         if (cur + x <= x + y && set.add(cur + x)) {
    //             queue.offer(cur + x);
    //         }
    //         if (cur + y <= x + y && set.add(cur + y)) {
    //             queue.offer(cur + y);
    //         }
    //         if (cur - x >= 0 && set.add(cur - x)) {
    //             queue.offer(cur - x);
    //         }
    //         if (cur - y >= 0 && set.add(cur - y)) {
    //             queue.offer(cur - y);
    //         }
    //         if (set.contains(z)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // GCD solution
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == z || y == z || x + y == z) return true;
        return z % gcd(x, y) == 0;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}
