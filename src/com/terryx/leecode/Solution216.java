package com.terryx.leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 8/10/17 10:47 AM.
 */
public class Solution216 {
    private List<List<Integer>> res = new ArrayList<>();

    private void dfs(int cur, int size, int target, List<Integer> list) {
        // System.out.println(cur + " " + target);
        if (target < 0 || list.size() > size) return;

        if (target == 0 && list.size() == size) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur + 1; i <= 9; ++i) {
            list.add(i);
            dfs(i, size, target - i, list);
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, k, n, new ArrayList<Integer>());
        return res;
    }
}
