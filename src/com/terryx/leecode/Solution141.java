package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 4:35 PM.
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode first = start;
        ListNode second = start.next;
        while (first != null && second != null && first != second && second.next != null) {
            first = first.next;
            second = second.next.next;
        }
        if (first == second) return true;
        return false;
    }
}
