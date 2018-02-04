package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/13/17 8:37 PM.
 */
public class Solution637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) return new ArrayList<Double>(0);
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0.0;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                sum += cur.val;
            }
            res.add(sum / (double) size);
        }
        return res;
    }
}
