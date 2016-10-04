package com.terryx.leecode;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/3/16 8:12 PM.
 */
public class Solution143 {
    public void reorderList(ListNode head) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            cnt++;
            cur = cur.next;
        }
        int half = (cnt + 1) / 2;
        if (cnt % 2 > 0) half++;
        cnt = 0;
        cur = head;
        ListNode second = head;
        while (cur != null) {
            cnt ++;
            if (cnt == half) {
                second = cur;
                break;
            }
            cur = cur.next;
        }
        cur = head;
        ListNode halfP = second;
        ListNode start = new ListNode(0);
        while (cur != halfP) {
            if (second == null) {
                start.next = cur;
                cur.next = null;
                break;
            } else {
                start.next = cur;
                ListNode next = cur.next;
                cur.next = second;
                start = second;
                cur = next;
                second = second.next;
            }
        }
    }
}
