package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/30/17 2:42 AM.
 */
public class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int up[] = new int[nums.length];
        int dn[] = new int[nums.length];

        // O(n ^ 2) DP
        // for (int i = 1; i < nums.length; ++ i) {
        //     for (int j = 0; j < i; ++ j) {
        //         if (nums[i] > nums[j]) {
        //             up[i] = Math.max(up[i], dn[j] + 1);
        //         } else if (nums[i] < nums[j]) {
        //             dn[i] = Math.max(dn[i], up[j] + 1);
        //         }
        //     }
        // }
        // return 1 + Math.max(dn[nums.length - 1], up[nums.length - 1]);

        // O(n) DP
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                up[i] = Math.max(up[i], dn[i - 1] + 1);
                dn[i] = dn[i - 1];
            } else if (nums[i] < nums[i - 1]) {
                dn[i] = Math.max(dn[i], up[i - 1] + 1);
                up[i] = up[i - 1];
            } else {
                dn[i] = dn[i - 1];
                up[i] = up[i - 1];
            }
        }
        return 1 + Math.max(dn[nums.length - 1], up[nums.length - 1]);
    }
}
