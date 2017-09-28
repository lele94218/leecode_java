package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.Stack;

/**
 * @author taoranxue on 8/29/16 4:58 PM.
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode p = new TreeNode(postorder[postEnd]);
        int index = -1;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == p.val) {
                index = i;
                break;
            }
        }
        p.left = helper(inorder, postorder, postEnd - inEnd + index - 1, inStart, index - 1);
        p.right = helper(inorder, postorder, postEnd - 1, index + 1, inEnd);
        return p;
    }

    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length <= 0) return null;
        int i = postorder.length - 1, j = inorder.length - 1;
        TreeNode root = new TreeNode(postorder[i]);
        --i;
        boolean flag = false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = root;
        while (i >= 0) {
            if (!stack.isEmpty() && stack.peek().val == inorder[j]) {
                cur = stack.pop();
                flag = true;
                --j;
            } else if (!flag) {
                cur.right = new TreeNode(postorder[i]);
                cur = cur.right;
                stack.push(cur);
                --i;
            } else {
                flag = false;
                cur.left = new TreeNode(postorder[i]);
                cur = cur.left;
                stack.push(cur);
                --i;
            }
        }
        return root;
    }
}
