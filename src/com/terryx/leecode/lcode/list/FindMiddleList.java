package com.terryx.leecode.lcode.list;

import com.terryx.main.ListNode;

import java.util.*;

/**
 * @author taoranxue on 10/1/17 4:56 PM.
 */
public class FindMiddleList {
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode slow = head, fast = slow;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
