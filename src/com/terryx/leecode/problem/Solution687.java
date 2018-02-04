package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 1/19/18 7:09 PM.
 */
public class Solution687 {
    private int res = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root, root.val);
        return res;
    }

    private int helper(TreeNode root, int value) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left, root.val);
        int right = helper(root.right, root.val);
        res = Math.max(res, left + right);
        return (value == root.val) ? Math.max(left, right) + 1 : 0;
    }
}
