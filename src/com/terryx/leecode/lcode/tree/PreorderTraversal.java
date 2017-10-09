package com.terryx.leecode.lcode.tree;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/7/17 3:29 PM.
 */
public class PreorderTraversal {
    public void iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                /*
                Do something
                 */
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }


    private void recursive(TreeNode root) {
        if (root == null) return;
       /*
       Do something
        */
        recursive(root.left);
        recursive(root.right);
    }
}
