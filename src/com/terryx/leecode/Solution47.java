package com.terryx.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author taoranxue on 10/26/16 10:49 PM.
 */
public class Solution47 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        dfs(nums, 0, new LinkedList<>());
        return res;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            res.add(tmp);
            return;
        }
        int n = nums[index];
        for (int i = 0; i <= tmp.size(); ++i) {
            if (i < tmp.size() && n == tmp.get(i)) continue;
            LinkedList<Integer> next = new LinkedList<>(tmp);
            next.add(i, n);
            dfs(nums, index + 1, next);
        }
    }
}
