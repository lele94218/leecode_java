package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 1:45 PM.
 */
public class Solution297 {
    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                if (tmp == null) {
                    sb.append("null");
                } else {
                    sb.append(tmp.val);
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
                if (!queue.isEmpty()) sb.append(",");
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            int index = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode cur = strToNode(index < nodes.length ? nodes[index++] : "null"), head = cur;
            queue.offer(cur);
            while (!queue.isEmpty()) {
                cur = queue.poll();
                if (cur == null) continue;
                TreeNode left = strToNode(index < nodes.length ? nodes[index++] : "null");
                TreeNode right = strToNode(index < nodes.length ? nodes[index++] : "null");
                cur.left = left;
                cur.right = right;
                if (left != null) queue.offer(left);
                if (right != null) queue.offer(right);
            }
            return head;
        }

        private TreeNode strToNode(String node) {
            return "null".equals(node) ? null : new TreeNode(Integer.parseInt(node));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
