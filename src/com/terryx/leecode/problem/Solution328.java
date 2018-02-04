package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

import java.util.Collections;

/**
 * @author taoranxue on 10/1/16 2:08 AM.
 */
public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode(0);
        ListNode oddHead = new ListNode(0);
        ListNode even = evenHead;
        ListNode odd = oddHead;
        ListNode cur = head;
        int cnt = 1;
        while (cur != null) {
            // even
            if (cnt % 2 == 0) {
                even.next = cur;
                even = even.next;
            } else { //odd
                odd.next = cur;
                odd = odd.next;
            }
            ++cnt;
            cur = cur.next;
        }
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;
    }
}
