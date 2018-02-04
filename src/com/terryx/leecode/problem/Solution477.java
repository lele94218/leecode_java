package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/6/17 3:00 PM.
 */
public class Solution477 {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int cnt = 0;
            for (int j = 0; j < nums.length; ++j) {
                if ((nums[j] >> i & 1) == 1) {
                    cnt++;
                }
            }
            res += cnt * (nums.length - cnt);
        }
        return res;
    }
}
