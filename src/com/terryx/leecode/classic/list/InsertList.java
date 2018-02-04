package com.terryx.leecode.classic.list;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/1/17 5:11 PM.
 */
public class InsertList {
    public ListNode insert(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) return newNode;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null && cur.val < value) {
            pre = cur;
            cur = cur.next;
        }
        pre.next = newNode;
        newNode.next = cur;
        return dummy.next;
    }
}
