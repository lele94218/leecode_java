package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

import java.util.*;

/**
 * @author taoranxue on 9/9/17 12:10 PM.
 */
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int len1 = 0, len2 = 0;
        ListNode cur = l1;
        while (cur != null) {
            len1 += 1;
            cur = cur.next;
        }
        cur = l2;
        while (cur != null) {
            len2 += 1;
            cur = cur.next;
        }
        int idx = Math.max(len1, len2);
        ListNode dummy = new ListNode(-1), cur1 = l1, cur2 = l2;
        cur = dummy;
        while (idx > 0) {
            if (idx <= len1 && idx <= len2) {
                cur.next = new ListNode(cur1.val + cur2.val);
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else if (idx <= len1) {
                cur.next = new ListNode(cur1.val);
                cur1 = cur1.next;
            } else if (idx <= len2) {
                cur.next = new ListNode(cur2.val);
                cur2 = cur2.next;
            }
            idx--;
            cur = cur.next;
        }

        if (addHelper(dummy.next) == 1) {
            dummy.val = 1;
            return dummy;
        }
        return dummy.next;

    }

    private int addHelper(ListNode cur) {
        if (cur == null) return 0;
        cur.val += addHelper(cur.next);
        if (cur.val >= 10) {
            cur.val %= 10;
            return 1;
        }
        return 0;
    }
}
