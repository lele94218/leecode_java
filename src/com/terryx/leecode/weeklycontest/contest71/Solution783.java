package com.terryx.leecode.weeklycontest.contest71;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 2/10/18 9:30 PM.
 */
public class Solution783 {
    List<Integer> list = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        int res = Math.abs(list.get(1) - list.get(0));
        for (int i = 1; i < list.size(); ++ i) {
            res = Math.min(res, Math.abs(list.get(i) - list.get(i - 1)));
        }
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }
}
