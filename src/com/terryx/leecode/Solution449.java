package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author taoranxue on 6/6/17 7:57 PM.
 */
public class Solution449 {
    public class Codec {

        public String serialize(TreeNode root) {
            if (root == null) return "";
            StringBuilder res = new StringBuilder();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.append(cur.val).append(",");
                if (cur.right != null)
                    stack.push(cur.right);
                if (cur.left != null)
                    stack.push(cur.left);
            }
            return res.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) return null;
            String[] vals = data.split(",");
            Queue<Integer> queue = new LinkedList<>();
            for (String val : vals) {
                queue.offer(Integer.parseInt(val));
            }
            return dfs(queue);
        }

        public TreeNode dfs(Queue<Integer> q) {
            if (q.isEmpty()) return null;
            Queue<Integer> sq = new LinkedList<>();
            Integer rootVal = q.poll();
            while (!q.isEmpty() && q.peek() < rootVal) {
                sq.offer(q.poll());
            }
            TreeNode root = new TreeNode(rootVal);
            root.left = dfs(sq);
            root.right = dfs(q);
            return root;
        }
    }
}
