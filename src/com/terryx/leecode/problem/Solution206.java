package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 9/30/16 6:36 PM.
 */
public class Solution206 {
    // iterative version
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head, nxt = cur.next, tmp = null;
        cur.next = pre;
        while (nxt != null) {
            tmp = nxt.next;
            nxt.next = cur;
            pre = cur;
            cur = nxt;
            nxt = tmp;
        }
        return cur;
    }

    // recursive version
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) return head;
//         ListNode res = helper(head, head.next);
//         head.next = null;
//         return res;
//     }

//     private ListNode helper(ListNode prev, ListNode cur) {
//         if (cur == null) return prev;
//         ListNode ret = helper(cur, cur.next);
//         cur.next = prev;
//         return ret;
//     }
}
