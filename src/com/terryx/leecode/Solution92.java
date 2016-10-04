package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/3/16 4:49 PM.
 */
public class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode cur = head;
        ListNode begin = start;
        ListNode end = head;
        int cnt = 1;
        ListNode reverse = new ListNode(0);
        while (cur != null) {
            if (cnt == m - 1) begin = cur;
            if (cnt >= m && cnt < n) {
                ListNode tmp = reverse.next;
                ListNode next = cur.next;
                reverse.next = cur;
                if (cnt == m) end = cur;
                cur.next = tmp;
                cur = next;
            } else if (cnt > m && cnt == n) {
                end.next = cur.next;
                ListNode tmp = reverse.next;
                reverse.next = cur;
                cur.next = tmp;
                break;
            } else {
                cur = cur.next;
            }
            cnt++;
        }
        if (reverse.next != null)
            begin.next = reverse.next;
        return start.next;
    }
}
