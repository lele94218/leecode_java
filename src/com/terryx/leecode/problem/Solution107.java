package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/12/17 12:22 PM.
 */
public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new ArrayList<List<Integer>>(0);
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                tmp.add(cur.val);
            }
            stack.push(tmp);
        }
        List<List<Integer>> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }
}
