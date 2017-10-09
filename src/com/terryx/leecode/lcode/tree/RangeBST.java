package com.terryx.leecode.lcode.tree;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/7/17 7:41 PM.
 */
public class RangeBST {
    public List<Integer> getRange(TreeNode root, int min, int max) {
        List<Integer> res = new ArrayList<>();
        helper(root, min, max, res);
        return res;
    }

    private void helper(TreeNode root, int min, int max, List<Integer> ans) {
        if (root == null) return;
        if (root.val >= min)
            helper(root.left, min, max, ans);
        if (root.val >= min && root.val <= max)
            ans.add(root.val);
        if (root.val <= max)
            helper(root.right, min, max, ans);
    }
}
