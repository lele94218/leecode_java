package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/1/16 4:53 PM.
 */
public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            ++cnt;
            cur = cur.next;
        }
        if (cnt > 0) k = k % cnt;
        int len = cnt - k;
        ListNode root = new ListNode(0);
        root.next = head;

        cur = root;
        ListNode start = new ListNode(0);
        ListNode second = start;
        System.out.println(start.next + "...");
        for (int i = 0; i <= cnt && len >= 0; ++i) {
            System.out.println(len + "ok............");
            if (i == len) {
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            } else if (i > len) {
                second.next = cur;
                second = second.next;
                cur = cur.next;
            } else {
                cur = cur.next;
            }
        }
        System.out.println(start.next + "...");
        if (start.next != null) {
            System.out.println("ok");
            second.next = root.next;
            System.out.println(start.next);
        } else {
            start.next = root.next;
        }
        return start.next;

    }
}
