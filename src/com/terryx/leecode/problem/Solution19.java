package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 2:13 PM.
 */
public class Solution19 {

    public ListNode removeNthFromEndSmart(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode first = start;
        ListNode second = start;
        start.next = head;
        for (int i = 0; i <= n; ++i) {
            first = first.next;
        }
        System.out.println(first);
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        System.out.println(second);
        second.next = second.next.next;
        return start.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int cnt = 0;
        while (curr != null) {
            curr = curr.next;
            cnt++;
        }
        n = cnt - n;
        cnt = 0;
        curr = head;
        if (n == 0) {
            return head.next;
        }
        while (curr != null) {
            if (++cnt == n) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        return head;
    }

}
