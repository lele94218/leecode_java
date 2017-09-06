package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/5/17 7:32 PM.
 */
public class Solution137 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            int cnt = 0, t = 1 << i;
            for (int j = 0; j < nums.length; ++j) {
                if ((nums[j] & t) != 0) cnt++;
                cnt %= 3;
            }
            if (cnt > 0)
                res |= (1 << i);
        }
        return res;
    }
}
