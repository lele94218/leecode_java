package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.Stack;

/**
 * @author taoranxue on 8/29/16 3:50 PM.
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        // System.out.println(preStart + " " + inStart + " " + inEnd);
        TreeNode p = new TreeNode(preorder[preStart]);
        int index = -1;
        for (int i = inStart; i <= inEnd; ++ i) {
            if (inorder[i] == p.val) {
                index = i;
                break;
            }
        }
        p.left = helper(preorder, inorder, preStart + 1, inStart, index - 1);
        p.right = helper(preorder, inorder, preStart + index - inStart + 1, index + 1, inEnd);
        return p;
    }
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
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
