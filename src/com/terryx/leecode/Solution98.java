package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.Stack;

/**
 * @author taoranxue on 10/30/16 9:59 PM.
 */
public class Solution98 {
    // iteration version
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    // recursion version
//     public boolean isValidBST(TreeNode root) {
//         return helper(root, (long)Integer.MIN_VALUE - 1, (long)Integer.MAX_VALUE + 1);
//     }

//     private boolean helper(TreeNode root, long low, long high) {
//         if (root == null) return true;
//         return (long)root.val > low && (long)root.val < high
//             && helper(root.left, low, (long)root.val) && helper(root.right, (long)root.val, high);
//     }
}
