package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 8/28/16 3:50 PM.
 */
public class Solution144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            ans.add(curr.val);
            if (curr.right != null)
                stack.push(curr.right);
            curr = curr.left;
            if (curr == null && !stack.isEmpty()) {
                curr = stack.pop();
            }

        }
        return ans;
    }
}
