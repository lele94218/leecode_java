package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/1/16 5:37 PM.
 */
public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = new ListNode(9999999);
        start.next = head;
        ListNode cur = start;
        ListNode pre = start;
        boolean flag = false;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                flag = true;
            } else if (flag) {
                pre.next = cur.next;
                cur = cur.next;
                flag = false;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        if (flag) {
            pre.next = null;
        }
        return start.next;
    }
}
