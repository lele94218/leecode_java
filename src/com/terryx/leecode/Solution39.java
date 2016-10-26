package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/25/16 10:11 PM.
 */
public class Solution39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, int target, ArrayList<Integer> tmp) {
        if (target > 0) {
            for (int i = index; i < nums.length && nums[i] <= target; ++i) {
                tmp.add(nums[i]);
                dfs(nums, i, target - nums[i], tmp);
                tmp.remove(tmp.size() - 1);
            }
        } else if (target == 0) {
            res.add(new ArrayList<>(tmp));
        }
    }

}
