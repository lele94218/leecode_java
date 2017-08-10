package com.terryx.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taoranxue on 8/10/17 9:40 PM.
 */
public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (map.get(sum - k) != null) {
                res += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
