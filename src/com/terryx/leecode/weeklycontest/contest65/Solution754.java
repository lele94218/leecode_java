package com.terryx.leecode.weeklycontest.contest65;

/**
 * @author taoranxue on 12/30/17 9:39 PM.
 */
public class Solution754 {
    public int reachNumber(int target) {
        if (target < 0) {
            target = -target;
        }

        int step = 0, sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }

        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}
