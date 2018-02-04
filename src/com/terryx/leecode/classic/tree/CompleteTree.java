package com.terryx.leecode.classic.tree;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/11/17 4:29 PM.
 */
public class CompleteTree {
    public boolean isCompleted(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.left);
            }

            if (cur.right == null) {
                flag = true;
            } else if (flag) {
                return false;
            } else {
                queue.offer(cur.right);
            }
        }
        return true;
    }
}
