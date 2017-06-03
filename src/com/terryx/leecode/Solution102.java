package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 6/1/17 8:04 PM.
 */
public class Solution102 {
    public class TreeNodeWrap {
        public TreeNode tn;
        public int level;
        public TreeNodeWrap(TreeNode tn, int level) {
            this.tn = tn;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        Queue<TreeNodeWrap> queue = new LinkedList<>();
        queue.offer(new TreeNodeWrap(root, 0));
        List<Integer> tmp = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNodeWrap cur = queue.poll();
            tmp.add(cur.tn.val);
            if (cur.tn.left != null)
                queue.offer(new TreeNodeWrap(cur.tn.left, cur.level + 1));
            if (cur.tn.right != null)
                queue.offer(new TreeNodeWrap(cur.tn.right, cur.level + 1));

            if (queue.isEmpty() || queue.peek().level != cur.level) {
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }

        }
        return res;
    }
}
