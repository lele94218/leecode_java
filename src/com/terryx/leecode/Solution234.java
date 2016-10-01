package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 7:07 PM.
 */
public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode cur = head;
        ListNode start = head.next;
        ListNode half = head;

        while (half.next != null && half.next.next != null) {
            half = half.next.next;
            ListNode tmp = cur;
            cur = start;
            start = start.next;
            cur.next = tmp;
        }

        if (half.next == null) {
            cur = cur.next;
        }
        System.out.println(cur + " " + start);
        while (cur != null && start != null) {
            System.out.println("ok");
            if (cur.val != start.val) return false;
            cur = cur.next;
            start = start.next;
        }
        return true;
    }
}
