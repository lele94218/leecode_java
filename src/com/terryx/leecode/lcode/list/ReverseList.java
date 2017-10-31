package com.terryx.leecode.lcode.list;

import com.terryx.main.ListNode;

import java.util.*;

/**
 * @author taoranxue on 10/1/17 4:51 PM.
 */
public class ReverseList {
    public ListNode reverseIter(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head, pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }


    public ListNode reverseRecr(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseRecr(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;

    }
}
