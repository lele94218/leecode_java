package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author taoranxue on 8/28/16 4:40 PM.
 */
public class Solution145 {
    /**
     * reverse the answer of postorder traversal is the preorder traversal but visits right children first.
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            ans.addFirst(curr.val);
            if (curr.left != null) {
                stack.push(curr.left);
            }
            curr = curr.right;
            if (curr == null && !stack.empty()) {
                curr = stack.pop();
            }
        }
        return ans;
    }
}
