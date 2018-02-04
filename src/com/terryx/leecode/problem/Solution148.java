package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

/**
 * @author taoranxue on 10/8/16 5:57 PM.
 */
public class Solution148 {
    private ListNode cur;

    public ListNode mergeSort(int left, int right) {
        if (left > right) return null;
        if (left == right) return new ListNode(cur.val);
        int mid = left + (right - left) / 2;
        ListNode leftList = mergeSort(left, mid);
        cur = cur.next;
        ListNode rightList = mergeSort(mid + 1, right);
        ListNode tmp = new ListNode(0);
        ListNode cur = tmp;
        while (leftList != null || rightList != null) {
            if (leftList == null) {
                cur.next = rightList;
                rightList = rightList.next;
            } else if (rightList == null) {
                cur.next = leftList;
                leftList = leftList.next;
            } else if (leftList.val < rightList.val) {
                cur.next = leftList;
                leftList = leftList.next;
            } else {
                cur.next = rightList;
                rightList = rightList.next;
            }
            cur = cur.next;
        }
        return tmp.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        cur = head;
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return mergeSort(0, size - 1);
    }
}
