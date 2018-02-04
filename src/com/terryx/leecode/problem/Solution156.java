package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/12/17 4:11 PM.
 */
public class Solution156 {
    // recurision
    // public TreeNode upsideDownBinaryTree(TreeNode root) {
    //     if (root == null || root.left == null) return root;
    //     TreeNode newRoot = upsideDownBinaryTree(root.left);
    //     root.left.left = root.right;
    //     root.left.right = root;
    //     root.left = null;
    //     root.right = null;
    //     return newRoot;
    // }

    // iteration
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root, prev = null, next = null, tmp = null;
        while (cur != null) {
            next = cur.left;
            cur.left = tmp;
            tmp = cur.right;
            cur.right = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }
}
