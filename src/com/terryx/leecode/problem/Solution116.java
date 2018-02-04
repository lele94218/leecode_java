package com.terryx.leecode.problem;

import com.terryx.main.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taoranxue on 6/3/17 2:16 AM.
 */
public class Solution116 {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode cur = root;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            root = root.left;
        }
    }
}
