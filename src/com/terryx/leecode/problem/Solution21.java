package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 4:08 PM.
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        ListNode currL1 = l1;
        ListNode currL2 = l2;
        while (currL1 != null || currL2 != null) {
            if (currL1 == null) {
                curr.next = new ListNode(currL2.val);
                currL2 = currL2.next;
            } else if (currL2 == null) {
                curr.next = new ListNode(currL1.val);
                currL1 = currL1.next;
            } else {
                if (currL1.val < currL2.val) {
                    curr.next = new ListNode(currL1.val);
                    currL1 = currL1.next;
                } else {
                    curr.next = new ListNode(currL2.val);
                    currL2 = currL2.next;
                }
            }
            curr = curr.next;
        }
        return head.next;
    }
}
