package com.terryx.interview.facebook;

import com.terryx.main.TreeLinkNode;

/**
 * @author taoranxue on 10/22/17 4:57 PM.
 */
public class TreeNextPointer {
    public void connectPerfectTree(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        while (root.left != null) {
            TreeLinkNode cur = root;
            TreeLinkNode head = root.left;
            while (cur != null) {
                if (cur.left != null) {
                    head.next = cur.left;
                    head = head.next;
                }
                if (cur.right != null) {
                    head.next = cur.right;
                    head = head.next;
                }
                cur = cur.next;
            }
            root = root.left;
        }
    }

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
    /**
     * Last node connect to next level
     */
    public void connectNextLevel(TreeLinkNode root) {
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
            // just add
            cur.next = dummy.next;
            root = dummy.next;
        }
    }
}
