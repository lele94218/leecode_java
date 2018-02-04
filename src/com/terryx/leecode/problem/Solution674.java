package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/26/17 7:10 PM.
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int cnt = 1, res = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) cnt++;
            else {
                res = Math.max(res, cnt);
                cnt = 1;
            }
        }
        if (cnt != 1) res = Math.max(res, cnt);
        return res;
    }
}
