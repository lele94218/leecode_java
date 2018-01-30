package com.terryx.leecode.weeklycontest.contest50;

import java.util.*;

/**
 * @author taoranxue on 9/16/17 10:21 PM.
 */
public class Solution679 {
    public boolean judgePoint24(int[] nums) {
        if (nums == null) return false;
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i)
            list.add((double) nums[i]);
        return dfs(list);
    }

    private boolean dfs(List<Double> nums) {
        // for (int i = 0; i < nums.size(); ++ i) {
        //     System.out.print(nums.get(i) + " ");
        // }
        // System.out.println();
        if (nums.size() == 1) {
            // System.out.println(nums.get(0));
            return Math.abs(nums.get(0) - 24.0) < 1e-6;
        }
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = 0; j < nums.size(); ++j)
                if (i != j) {
                    double a = nums.get(i), b = nums.get(j);
                    List<Double> nextNums = new ArrayList<>();
                    for (int k = 0; k < nums.size(); ++k)
                        if (i != k && j != k) {
                            nextNums.add(nums.get(k));
                        }
                    for (int k = 1; k <= 4; ++k) {
                        if (k == 1) {
                            nextNums.add(a + b);
                        }
                        if (k == 2) {
                            nextNums.add(a - b);
                        }
                        if (k == 3) {
                            nextNums.add(a * b);
                        }
                        if (k == 4) {
                            if (b != 0.0) nextNums.add(a / b);
                            else continue;
                        }
                        if (dfs(nextNums)) return true;
                        nextNums.remove(nextNums.size() - 1);
                    }
                }
        }
        return false;
    }
}
