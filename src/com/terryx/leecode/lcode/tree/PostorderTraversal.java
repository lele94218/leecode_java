package com.terryx.leecode.lcode.tree;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/7/17 3:59 PM.
 */
public class PostorderTraversal {

    private void recursive(TreeNode root, List<Integer> ans) {
        if (root == null) return;
        recursive(root.left, ans);
        recursive(root.right, ans);
         /*
         Do something
          */
    }

    public void iterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        LinkedList<Integer> res = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                /*
                Do something
                 */
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }
    }

}
