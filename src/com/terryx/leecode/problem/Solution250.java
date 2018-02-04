package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/12/17 12:13 PM.
 */
public class Solution250 {
    public int countUnivalSubtrees(TreeNode root) {
        return Math.abs(helper(root));
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int left = helper(root.left), right = helper(root.right);
        if (root.left == null) {
            if (right >= 0 && root.val == root.right.val) {
                return 1 + right;
            }
        } else if (root.right == null) {
            if (left >= 0 && root.val == root.left.val) {
                return 1 + left;
            }
        } else {
            if (root.val == root.right.val && root.val == root.left.val && left >= 0 && right >= 0) {
                return 1 + right + left;
            }
        }
        Stack stack = new Stack();
        return -(Math.abs(right) + Math.abs(left));
    }
}
