package com.terryx.main;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taoranxue on 9/23/16 2:14 AM.
 */
public class Utils extends ListNode {
    protected int a;
    public void fun() {
        getS();
    }

    public Utils() {

    }

    public static void main(String args[]) {
        Utils utils = new Utils();
    }
    public static String debug(Object ... objects) {
        String str = "";
        for (int i = 0; i < objects.length; ++ i) {
            str += objects[i].toString();
            str += " ";
        }
        str += "\n";
        return str;
    }

    public static String debug(int[] nums) {
        String str = "";
        for (int i = 0; i < nums.length; ++ i) {
            str += nums[i];
            str += " ";
        }
        str += "\n";
        return str;
    }

    public static TreeNode genTree(String str) {
        String[] nodes = str.substring(1, str.length() - 1).split(",");
        if (nodes.length <= 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        int p = 1;
        while (p < nodes.length) {
            TreeNode tmp = queue.poll();
            String nodeStr = nodes[p++];
            if ("null".equals(nodeStr)) {
                tmp.left = null;
            } else {
                tmp.left = new TreeNode(Integer.parseInt(nodeStr));
                queue.offer(tmp.left);
            }
            nodeStr = nodes[p++];
            if ("null".equals(nodeStr)) {
                tmp.right = null;
            } else {
                tmp.right = new TreeNode(Integer.parseInt(nodeStr));
                queue.offer(tmp.right);
            }
        }
        return root;
    }
}
