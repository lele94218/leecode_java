package com.terryx.leecode.contest42;

import java.util.HashMap;

/**
 * @author taoranxue on 7/23/17 9:31 AM.
 */
public class Solution645 {
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length == 1) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int a = 0, b = 0;
        for (int i = 1; i <= nums.length; ++i) {
            if (!map.containsKey(i)) {
                b = i;
            } else if (map.get(i) > 1) {
                a = i;
            }
        }
        return new int[]{a, b};
    }
}
