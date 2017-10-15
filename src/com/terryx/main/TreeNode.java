package com.terryx.main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taoranxue on 8/28/16 2:47 PM.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp == null) {
                sb.append("null,");
            } else {
                sb.append(tmp.val).append(",");
                queue.offer(tmp.left);
                queue.offer(tmp.right);
            }
        }
        String ans = sb.toString();
        if (ans.charAt(ans.length() - 1) == ',') {
            ans = ans.substring(0, ans.length() - 1);
        }
        return ans += ']';
    }
}
