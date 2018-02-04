package com.terryx.leecode.problem;

import com.terryx.main.TreeLinkNode;

/**
 * @author taoranxue on 6/3/17 3:00 AM.
 */
public class Solution117 {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            //save head
            TreeLinkNode dummy = new TreeLinkNode(-1);
            //save head in the prev dummy list
            TreeLinkNode prev = root;
            //using to connect current level node;
            TreeLinkNode cur = dummy;
            while (prev != null) {
                if (prev.left != null) {
                    cur.next = prev.left;
                    cur = cur.next;
                }
                if (prev.right != null) {
                    cur.next = prev.right;
                    cur = cur.next;
                }
                prev = prev.next;
            }
            root = dummy.next;
        }
    }
}
