package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/6/16 10:06 PM.
 */
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        ListNode start = new ListNode(0);
        ListNode pre = start;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            pre = start;
        }
        return start.next;
    }
}
