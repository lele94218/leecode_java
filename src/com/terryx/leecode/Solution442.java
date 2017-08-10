package com.terryx.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 8/10/17 4:16 PM.
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>(0);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int ix = Math.abs(nums[i]) - 1;
            if (nums[ix] < 0) {
                res.add(ix + 1);
            }
            nums[ix] = -nums[ix];
        }
        return res;
    }
}
