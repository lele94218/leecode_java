package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 6:46 PM.
 */
public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null) {
            return res;
        }
        if (nums.length == 0) {
            if ((long) upper - lower > 0L) {
                res.add(lower + "->" + upper);
            } else if (upper == lower) {
                res.add(lower + "");
            }
            return res;
        }
        for (int i = 0; i <= nums.length; ++i) {
            long first, second;
            if (i > 0 && i < nums.length) {
                first = (long) nums[i - 1] + 1;
                second = (long) nums[i] - 1;
            } else if (i == 0) {
                first = lower;
                second = (long) nums[i] - 1;
            } else {
                first = (long) nums[i - 1] + 1;
                second = upper;
            }
            //System.out.println(first + " " + second);
            if (second - first > 0) {
                res.add(first + "->" + second);
            } else if (first == second) {
                res.add(first + "");
            }
        }
        return res;
    }
}
