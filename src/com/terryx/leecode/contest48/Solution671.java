package com.terryx.leecode.contest48;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/2/17 9:30 PM.
 */
public class Solution671 {
    private Set<Integer> set;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        set = new HashSet<>();
        dfs(root);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        if (list.size() == 1) return -1;
        return list.get(1);
    }

    private void dfs(TreeNode cur) {
        if (cur == null) return;
        set.add(cur.val);
        dfs(cur.left);
        dfs(cur.right);
    }
}
