package com.terryx.leecode.problem;

import com.terryx.main.ListNode;


/**
 * @author taoranxue on 10/1/16 3:54 PM.
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode p, ListNode q) {
        ListNode pRe = new ListNode(0);
        ListNode qRe = new ListNode(0);
//        while (cur != null) {
//            ListNode next = cur.next;
//            ListNode tmp = pRe.next;
//            pRe.next = cur;
//            cur.next = tmp;
//            cur = next;
//        }
//        cur = q;
//        while (cur != null) {
//            ListNode next = cur.next;
//            ListNode tmp = qRe.next;
//            qRe.next = cur;
//            cur.next = tmp;
//            cur = next;
//        }
        pRe.next = p;
        qRe.next = q;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int c = 0;
        while (pRe.next != null || qRe.next != null) {
            int sum;
            if (pRe.next == null) {
                sum = qRe.next.val + c;
                qRe = qRe.next;
            } else if (qRe.next == null) {
                sum = pRe.next.val + c;
                pRe = pRe.next;
            } else {
                sum = pRe.next.val + qRe.next.val + c;
                qRe = qRe.next;
                pRe = pRe.next;
            }
            c = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }
        if (c > 0) {
            cur.next = new ListNode(c);
            cur = cur.next;
        }
        return result.next;
    }
}
