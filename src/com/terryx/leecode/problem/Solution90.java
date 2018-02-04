package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taoranxue on 10/25/16 8:30 PM.
 */
public class Solution90 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> tmp) {
        if (index <= nums.length)
            res.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; ++i) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            tmp.add(nums[i]);
            dfs(nums, i + 1, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
