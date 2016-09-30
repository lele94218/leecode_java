package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 4:31 PM.
 */
public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(-99999999);
        start.next = head;
        ListNode curr = start;
        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return start.next;
    }
}
