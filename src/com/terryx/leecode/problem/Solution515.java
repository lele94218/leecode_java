package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author taoranxue on 6/8/17 8:38 PM.
 */
public class Solution515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int queueSize = 1;
        while (!queue.isEmpty()) {
            int tmp = Integer.MIN_VALUE;
            while (queueSize-- > 0) {
                TreeNode cur = queue.poll();
                tmp = Math.max(tmp, cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            res.add(tmp);
            queueSize = queue.size();
        }
        return res;
    }
}
