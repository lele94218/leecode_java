package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 6:36 PM.
 */
public class Solution206 {
    private ListNode ans;
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null) {
            ans = new ListNode(0);
            return ans;
        }
        ListNode cur = reverseListRecursive(head.next);
        cur.next = head;
        return head;
    }
    public ListNode reverseList1(ListNode head) {
        ListNode cur = reverseListRecursive(head);
        cur.next = null;
        return ans.next;
    }
    public ListNode reverseList(ListNode head) {
        ListNode start = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = start.next;
            ListNode _next = cur.next;
            start.next = cur;
            start.next.next = tmp;
            cur = _next;
        }
        return start.next;
    }
}
