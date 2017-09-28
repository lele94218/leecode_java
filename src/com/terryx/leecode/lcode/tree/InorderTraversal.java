package com.terryx.leecode.lcode.tree;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/27/17 1:00 PM.
 */
public class InorderTraversal {
    public void recurse(TreeNode root) {
        if (root == null) return;
        recurse(root.left);
        /*
        Do something...
         */
        recurse(root.right);
    }

    public void iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root.left);
            }
            root = stack.pop();
            /*
            Do something.
             */
            root = root.right;
        }
    }
}
