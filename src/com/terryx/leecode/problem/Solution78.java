package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 10/24/16 10:59 PM.
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        int n = nums.length;
        int m = (1 << n);
        for (int i = 0; i < m; ++ i) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = n - 1; j >= 0; -- j) {
                if (((i >> j) & 1) == 1) {
                    tmp.add(nums[j]);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}
