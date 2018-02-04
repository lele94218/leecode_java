package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 12:58 PM.
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (k != 0)
                sum %= k;
            Integer v = map.get(sum);
            if (v != null) {
                if (i - v > 1)
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
