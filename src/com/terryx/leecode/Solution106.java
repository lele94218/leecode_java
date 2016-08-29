package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.Stack;

/**
 * @author taoranxue on 8/29/16 4:58 PM.
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length <= 0) return null;
        int i = postorder.length - 1, j = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[i]);
        -- i;
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while (i >= 0) {
            if (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                cur = stack.pop();
                flag = true;
                -- j;
            } else if (!flag) {
                cur.right = new TreeNode(postorder[i]);
                cur = cur.right;
                stack.push(cur);
                -- i;
            } else {
                flag = false;
                cur.left = new TreeNode(postorder[i]);
                cur = cur.left;
                stack.push(cur);
                -- i;
            }
        }
        return root;
    }
}
