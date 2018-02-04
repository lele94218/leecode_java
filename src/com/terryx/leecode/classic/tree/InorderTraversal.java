package com.terryx.leecode.classic.tree;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/27/17 1:00 PM.
 */
public class InorderTraversal {
    public void recursive(TreeNode root) {
        if (root == null) return;
        recursive(root.left);
        /*
        Do something...
         */
        recursive(root.right);
    }

    public void iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                /*
                Do something
                 */
                cur = cur.right;
            }
        }
    }
}
