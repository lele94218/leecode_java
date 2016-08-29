package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.Stack;

/**
 * @author taoranxue on 8/29/16 3:50 PM.
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode curr = root;
        stack.push(curr);
        int i = 1, j = 0;
        boolean flag = false;
        while (i < preorder.length) {
            if (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                curr = stack.pop();
                flag = true;
                ++ j;
            } else if (!flag) {
                curr.left = new TreeNode(preorder[i]);
                curr = curr.left;
                stack.push(curr);
                ++ i;
            } else {
                flag = false;
                curr.right = new TreeNode(preorder[i]);
                curr = curr.right;
                stack.push(curr);
                ++ i;
            }
        }
        return root;
    }
}
