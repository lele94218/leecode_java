package com.terryx.leecode.weeklycontest.contest49;

import java.util.*;

/**
 * @author taoranxue on 3/1/18 3:06 PM.
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int pre = nums[0];
        int ans = 1, cnt = 1;
        for (int i = 1; i < nums.length; ++ i) {
            int nxt = nums[i];
            if (nxt > pre) {
                cnt++;
            } else {
                ans = Math.max(ans, cnt);
                cnt = 1;
            }
            pre = nxt;
        }
        return Math.max(ans, cnt);
    }

    public static void main(String[] args) {
        Solution674 m = new Solution674();
        System.out.println(m.findLengthOfLCIS(new int[]{2,2,2,2,200}));
    }
}
