package com.terryx.leecode;

import java.util.HashMap;

/**
 * @author taoranxue on 8/29/16 5:22 PM.
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                int sum = left + right + 1;
                map.put(n, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
                res = Math.max(sum, res);
            }
        }
        return res;
    }
}
