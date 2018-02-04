package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author taoranxue on 10/26/16 10:35 PM.
 */
public class Solution46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        int n = nums[index];
        for (int i = 0; i <= tmp.size(); ++i) {
            LinkedList<Integer> next = new LinkedList<>(tmp);
            next.add(i, n);
            dfs(nums, index + 1, next);
        }
    }
}
