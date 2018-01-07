package com.terryx.leecode.contest65;

import java.util.*;

/**
 * @author taoranxue on 12/30/17 9:39 PM.
 */
public class Solution754 {
    public int reachNumber(int target) {
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            target = -target;
        }
        int sum = 0, abs = Integer.MAX_VALUE, i = 1, tmp = 0;
        while (sum <= target) {
            sum += i;
            ++i;
        }
        tmp = sum - i + 1;
        if (Math.abs(sum - target) < Math.abs(tmp - target)) {
            abs = Math.abs(sum - target);
        } else {
            abs = Math.abs(tmp - target);
            i = i - 1;
        }
        return i - 1 + 2 * abs;
    }

    public static void main(String[] args) {
        Solution754 m = new Solution754();
        System.out.println(m.reachNumber(5));
    }
}
