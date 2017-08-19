package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/19/17 12:27 PM.
 */
public class Solution525 {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cnt = 0, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) cnt--;
            else cnt++;
            Integer v = map.get(cnt);
            if (v != null) {
                res = Math.max(res, i - v);
            } else {
                map.put(cnt, i);
            }
            String s;
            
        }
        return res;
    }
}
