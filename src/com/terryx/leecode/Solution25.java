package com.terryx.leecode;

import com.terryx.main.ListNode;

import java.util.*;

/**
 * @author taoranxue on 9/1/17 11:35 AM.
 */
public class Solution25 {
    // Recurisive solution
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if (head == null) return head;
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
//         ListNode cur = head, curPrev = dummy;
//         while (cur != null) {
//             ListNode tmpCur = cur;
//             for (int i = 0; i < k - 1; ++ i) {
//                 if (tmpCur == null) {
//                     break;
//                 }
//                 tmpCur = tmpCur.next;
//             }

//             if (tmpCur != null) {
//                 reverseKNodes(cur, curPrev, curPrev, tmpCur.next);
//             }
//             curPrev = cur;
//             if (cur != null)
//                 cur = cur.next;
//             else
//                 cur = null;
//         }
//         return dummy.next;
//     }

//     private void reverseKNodes(ListNode cur, ListNode curPrev, ListNode oldPrev, ListNode oldNext) {
//         if (cur == oldNext) return;
//         reverseKNodes(cur.next, cur, oldPrev, oldNext);
//         if (cur.next == oldNext && oldPrev != null)
//             oldPrev.next = cur;
//         if (curPrev == oldPrev)
//             cur.next = oldNext;
//         else
//             cur.next = curPrev;
//     }

    // Iteration solution
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1), cur = head, pre = dummy;
        dummy.next = head;
        int cnt = 0;
        while (cur != null) {
            cur = cur.next;
            cnt++;
        }

        cur = head;
        while (cnt >= k) {
            ListNode nextTo = null, tmp = null;
            for (int i = 1; i < k; ++i) {
                // System.out.println(pre.val + " " + cur.val);
                nextTo = cur.next;
                tmp = nextTo.next;
                nextTo.next = pre.next;
                pre.next = nextTo;
                cur.next = tmp;
            }
            pre = cur;
            cur = cur.next;
            cnt -= k;
        }
        return dummy.next;
    }
}
