package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/14/17 5:39 PM.
 */
public class Solution314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>(0);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueIdx = new LinkedList<>();
        queue.offer(root);
        queueIdx.offer(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                int idx = queueIdx.poll();
                left = Math.min(left, idx);
                right = Math.max(right, idx);
                if (map.containsKey(idx)) {
                    map.get(idx).add(cur.val);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(cur.val);
                    map.put(idx, list);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                    queueIdx.offer(idx - 1);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                    queueIdx.offer(idx + 1);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (map.containsKey(i)) {
                res.add(map.get(i));
            }
        }
        return res;
    }
}
