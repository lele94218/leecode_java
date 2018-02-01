package com.terryx.interview.facebook;

import com.terryx.main.DoublyListNode;
import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 10/22/17 4:06 PM.
 */
public class ConvertBST2DoublyLinkedList {
    DoublyListNode cur = new DoublyListNode(-1);

    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        DoublyListNode head = cur;
        helper(root);
        return head.next;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        cur.next = new DoublyListNode(root.val);
        cur.next.prev = cur;
        cur = cur.next;
        helper(root.right);
    }

    /**
     * Iterative version
     */
    public DoublyListNode bstToDoublyList1(TreeNode root) {
        DoublyListNode dummy = new DoublyListNode(-1);
        DoublyListNode curNode = dummy;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode tmp = stack.pop();
                curNode.next = new DoublyListNode(tmp.val);
                curNode.next.prev = curNode;
                curNode = curNode.next;
                cur = tmp.right;
            }
        }
        return dummy.next;
    }
}
