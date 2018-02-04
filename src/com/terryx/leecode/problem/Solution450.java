package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/8/17 5:33 PM.
 */
public class Solution450 {
    // recursion
    public TreeNode deleteNode0(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode min = findMin(root.right);
                // copy
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        TreeNode cur = root;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    // ---------------------------------------------------------------

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = cur;

        while (cur != null) {
            if (key == cur.val) {
                break;
            }

            pre = cur;

            if (key < cur.val) cur = cur.left;
            else cur = cur.right;
        }
        if (cur == null) {
            return root;
        }

        if (cur.right == null && cur.left == null) {
            if (cur == pre) {
                return null;
            } else {
                if (pre.right == cur) pre.right = null;
                else pre.left = null;
                return root;
            }
        }

        // no left children
        if (cur.left == null) {
            if (cur == pre) {
                return cur.right;
            } else {
                if (pre.right == cur) pre.right = cur.right;
                else pre.left = cur.right;
                return root;
            }
        }
        // no right children
        if (cur.right == null) {
            if (cur == pre) {
                return cur.left;
            } else {
                if (pre.right == cur) pre.right = cur.left;
                else pre.left = cur.left;
                return root;
            }

        }
        // has left/right children
        TreeNode select = cur.left;
        TreeNode selectPre = select;
        while (select.right != null) {
            selectPre = select;
            select = select.right;
        }
        selectPre.right = select.left;
        if (cur != pre) {
            if (pre.right == cur) pre.right = select;
            else pre.left = select;
        }
        if (cur.left != select)
            select.left = cur.left;
        if (cur.right != select)
            select.right = cur.right;

        if (cur == pre) {
            return select;
        }
        return root;

    }
}
