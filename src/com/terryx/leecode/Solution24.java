package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 4:15 PM.
 */
public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode curr = start;
        while (curr.next != null && curr.next.next != null) {
            ListNode o1 = curr;
            ListNode o2 = curr.next;
            ListNode o3 = curr.next.next;
            ListNode o4 = curr.next.next.next;
            o1.next = o3;
            o3.next = o2;
            o2.next = o4;
            curr = curr.next.next;
        }
        return start.next;
    }
}
