package com.terryx.leecode.lcode.list;

import java.util.*;

/**
 * @author taoranxue on 9/27/17 6:08 PM.
 */
public class FlattenLinkedList {
    static class ListNode {
        ListNode next, down;
        int val;
        ListNode(int val) {
            this.val = val;
        }
    }
    // recursive
    public ListNode flatten(ListNode root) {
        ListNode[] dummies = new ListNode[1];
        dummies[0] = new ListNode(-1);
        ListNode ans = dummies[0];
        helper(root, dummies);
        return ans.next;
    }

    private ListNode helper(ListNode root, ListNode tail[]) {
        if (root == null) return null;
        ListNode cur = root;
        while (cur != null) {
            System.out.println(cur.val);
            if (cur.down != null) {
                tail[0].next = cur;
                tail[0] = tail[0].next;
                ListNode tmp = cur.next;
                tail[0].next = helper(cur.down, tail);
                cur = tmp;
                continue;
            }

            tail[0].next = cur;
            tail[0] = tail[0].next;
            cur = cur.next;
        }
        return root;
    }

    public ListNode flattenByLevel(ListNode root) {
        if (root == null) return null;
        Queue<ListNode> queue = new LinkedList<>();
        ListNode dummy = new ListNode(-1), tail = dummy;
        queue.offer(root);
        while (!queue.isEmpty()) {
            ListNode t = queue.poll();
            while (t != null) {
                tail.next = t;
                tail = tail.next;
                if (t.down != null) queue.offer(t.down);
                t = t.next;
            }
        }
        return dummy.next;
    }

    public ListNode flattenByStack(ListNode root) {
        if (root == null) return null;
        Stack<ListNode> stack = new Stack<>();
        stack.push(root);
        ListNode dummy = new ListNode(-1), tail = dummy;
        while (!stack.isEmpty()) {
            ListNode t = stack.pop();
            while (t != null) {
                tail.next = t;
                tail = tail.next;
                if (t.down != null) {
                    stack.push(t.next);
                    t = t.down;
                } else {
                    t = t.next;
                }
            }
        }
        return  dummy.next;
    }

    public static void main(String[] args) {
        FlattenLinkedList flat = new FlattenLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(10);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l2.down = l5;
        l5.next = l6;
        l6.next = l7;
        l5.down = l8;
        l8.next = l9;
        l9.next = l10;
        ListNode root = flat.flattenByStack(l1);
        while (root != null) {
            System.out.print(root.val + "->");
            root = root.next;
        }
        System.out.println();
    }
}
