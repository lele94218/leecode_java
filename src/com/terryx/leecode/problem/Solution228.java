package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 8/10/17 11:27 AM.
 */
public class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>(0);
        int start = nums[0];
        List<String> res = new ArrayList<>();
        for (int i = 1; i < nums.length; ++ i) {
            if (nums[i - 1] + 1 != nums[i]) {
                int end = nums[i - 1];
                // System.out.println(start + " " + end);
                if (start != end) {
                    res.add(start + "->" + end);
                } else {
                    res.add(start + "");
                }
                start = nums[i];
            }
        }

        int end = nums[nums.length - 1];
        if (end != start) {
            res.add(start + "->" + end);
        } else {
            res.add(start + "");
        }
        return res;
    }
}
