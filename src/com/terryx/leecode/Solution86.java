package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/1/16 6:06 PM.
 */
public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode cur1 = smallHead;
        ListNode cur2 = bigHead;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = head;
            } else {
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        cur2.next = null;
        cur1.next = bigHead.next;
        return smallHead.next;
    }
}
