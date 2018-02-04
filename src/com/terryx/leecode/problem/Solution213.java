package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 10/20/16 8:02 PM.
 */
public class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        List<Integer> numList = new ArrayList<>();
        for (int a : nums) {
            numList.add(a);
        }
        int n = numList.size();
        List<Integer> firstList = numList.subList(0, n - 1);
        List<Integer> secondList = numList.subList(1, n);
        return Math.max(robWithAcyclic(firstList), robWithAcyclic(secondList));
    }

    private int robWithAcyclic(List<Integer> nums) {
        int exclude = 0;
        int include = 0;
        for (int a : nums) {
            int i = include;
            int e = exclude;
            include = e + a;
            exclude = Math.max(e, i);
        }
        return Math.max(exclude, include);
    }
}
