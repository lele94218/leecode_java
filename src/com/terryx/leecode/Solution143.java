package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/3/16 8:12 PM.
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // split
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode backHead = slow.next;
        slow.next = null;
        // reverse back head
        ListNode cur = backHead, pre = null, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode cur1 = head.next, cur2 = pre.next;
        // merge
        head.next = pre;
        ListNode tail = head.next;
        while (cur1 != null || cur2 != null) {
            if (cur1 != null) {
                tail.next = cur1;
                cur1 = cur1.next;
                tail = tail.next;
            }

            if (cur2 != null) {
                tail.next = cur2;
                cur2 = cur2.next;
                tail = tail.next;
            }
        }

    }
}
