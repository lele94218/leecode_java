package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 5:12 PM.
 */
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode start = new ListNode(99999999);
        start.next = head;
        ListNode cur = start.next;
        ListNode pre = start;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return start.next;
    }
}
