package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author taoranxue on 10/26/16 10:49 PM.
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int state, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i)
            if ((state & (1 << i)) == 0) {
                if (i > 0 && nums[i] == nums[i - 1] && (state & (1 << i - 1)) == 0) {
                    continue;
                }
                path.add(nums[i]);
                dfs(nums, state | (1 << i), path, ans);
                path.remove(path.size() - 1);
            }
    }
}
