package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * @author taoranxue on 8/28/16 2:46 PM.
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }
        return ans;
    }

//    private void doit(TreeNode root) {
//        if (root == null) return;
//        doit(root.left);
//        ans.add(root.val);
//        doit(root.right);
//    }

}
