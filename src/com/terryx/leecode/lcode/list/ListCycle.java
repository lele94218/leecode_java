package com.terryx.leecode.lcode.list;

import com.terryx.main.ListNode;

import java.util.*;

/**
 * @author taoranxue on 10/1/17 4:58 PM.
 */
public class ListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

}
