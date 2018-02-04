package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 12:02 PM.
 */
public class Solution369 {
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next == null) cur.val += 1;
            cur = cur.next;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        cur = head;
        if (plusHelper(cur) > 0) {
            dummy.val = 1;
            return dummy;
        }
        return dummy.next;
    }

    private int plusHelper(ListNode cur) {
        if (cur == null) return 0;
        cur.val += plusHelper(cur.next);
        int ret = cur.val / 10;
        cur.val %= 10;
        return ret;
    }
}
