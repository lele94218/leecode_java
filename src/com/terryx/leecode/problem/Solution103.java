package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taoranxue on 10/17/16 6:34 PM.
 */
public class Solution103 {
    private class MyNode {
        TreeNode node;
        int level;

        public MyNode(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<MyNode> queue = new LinkedList<>();
        queue.offer(new MyNode(root, 0));
        while (!queue.isEmpty()) {
            MyNode front = queue.poll();
            if (res.size() <= front.level) {
                res.add(new LinkedList<>());
            }

            if (front.level % 2 == 1) {
                ((LinkedList<Integer>)res.get(front.level)).addFirst(front.node.val);
            } else {
                res.get(front.level).add(front.node.val);
            }

            if (front.node.left != null) queue.offer(new MyNode(front.node.left, front.level + 1));
            if (front.node.right != null) queue.offer(new MyNode(front.node.right, front.level + 1));

        }
        return res;
    }
}
