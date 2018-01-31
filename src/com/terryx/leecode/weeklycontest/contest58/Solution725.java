package com.terryx.leecode.weeklycontest.contest58;

import com.terryx.main.ListNode;

import java.util.*;

/**
 * @author taoranxue on 1/30/18 10:23 PM.
 */
public class Solution725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int len = 0;
        if (root == null) {
            return new ListNode[k];
        }
        ListNode cur = root;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int r = len % k, n = len / k;
        ListNode[] res = new ListNode[k];
        cur = root;
        ListNode dummy = new ListNode(-1);
        for (int i = 0; i < k; ++i) {
            ListNode l = dummy;
            for (int j = 0; j < n + (i < r ? 1 : 0); ++j) {
                if (cur != null) {
                    l.next = cur;
                    l = l.next;
                    cur = cur.next;
                    l.next = null;
                }
            }
            res[i] = dummy.next;
            dummy.next = null;
        }
        return res;
    }
}
