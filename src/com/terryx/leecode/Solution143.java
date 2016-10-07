package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/3/16 8:12 PM.
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        ListNode preMid = p1;
        ListNode preCur = p1.next;

        if (preCur == null) return;

        while (preCur.next != null) {
            ListNode cur = preCur.next;
            preCur.next = cur.next;
            cur.next = preMid.next;
            preMid.next = cur;
        }

        p1 = head;
        p2 = preMid.next;
        while (p1 != preMid) {
            preMid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = preMid.next;
        }
    }
}
