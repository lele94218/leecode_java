package com.terryx.leecode;

import com.terryx.main.TreeLinkNode;

/**
 * @author taoranxue on 6/3/17 3:00 AM.
 */
public class Solution117 {
    public void connect(TreeLinkNode root) {
        while (root != null)
        {
            TreeLinkNode cur = root;
            TreeLinkNode dump = new TreeLinkNode(0);
            TreeLinkNode head = dump;
            while (cur != null) {
                if (root.left != null) {
                    dump.next = root.left;
                    dump = dump.next;
                }
                if (root.right != null) {
                    dump.next = root.right;
                    dump = dump.next;
                }
                cur = cur.next;
            }
            root = head.next;
        }
    }
}
