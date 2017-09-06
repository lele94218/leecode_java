package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/5/17 7:58 PM.
 */
public class Solution260 {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            res ^= nums[i];
        }

        res &= -res;
        int ret[] = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            if ((res & nums[i]) == 0) {
                ret[0] ^= nums[i];
            } else {
                ret[1] ^= nums[i];
            }
        }
        return ret;
    }
}
