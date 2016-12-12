package com.terryx.leecode;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 10/30/16 10:16 PM.
 */
public class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null)
            return null;

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return (left != null) ? left : root;
        }
    }
}
