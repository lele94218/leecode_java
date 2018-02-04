package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 4:53 PM.
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode start1 = new ListNode(0);
        ListNode start2 = new ListNode(0);
        start1.next = headA;
        start2.next = headB;
        ListNode cur1 = start1;
        ListNode cur2 = start2;
        int cnt1 = 1;
        int cnt2 = 1;
        while (cur1.next != null) {
            cur1 = cur1.next;
            cnt1 ++;
        }
        while (cur2.next != null) {
            cur2 = cur2.next;
            cnt2 ++;
        }
        if (cur1 != cur2) return null;
        cur1 = headA;
        cur2 = headB;
        int len = Math.abs(cnt1 - cnt2);
        for (int i = 0; i < len; ++ i) {
            if (cnt1 > cnt2) {
                cur1 = cur1.next;
            } else {
                cur2 = cur2.next;
            }
        }
        while (cur1 != null && cur2 != null && cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
