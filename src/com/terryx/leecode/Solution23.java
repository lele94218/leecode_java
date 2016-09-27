package com.terryx.leecode;

import com.terryx.main.Main;

import java.util.*;

/**
 * @author taoranxue on 9/26/16 9:12 PM.
 */
public class Solution23 {


    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return ("[" + val + "]");
        }
    }

    public ListNode[] lists;

    public void sink(int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) ++j;
            if (!less(k, j)) break;
            swap(k, j);
            k = j;
        }
    }

    public boolean less(int i, int j) {
        return lists[i - 1].val > lists[j - 1].val;
    }

    private void swap(int i, int j) {
        ListNode tmp = lists[i - 1];
        lists[i - 1] = lists[j - 1];
        lists[j - 1] = tmp;
    }

    private void heapify(int n) {
        for (int k = n / 2; k >= 1; --k) sink(k, n);
    }

    public ListNode mergeKLists(ListNode[] _lists) {
        ListNode root = new ListNode(0);
        ListNode curr = root;
        int n = _lists.length;
        this.lists = new ListNode[n];
        int k = 0;
        for (int i = 0; i < n; ++i) {
            if (_lists[i] != null) this.lists[k++] = _lists[i];
        }
        n = k;
        while (n > 0) {
            System.out.println(n);
            heapify(n);
            curr.next = new ListNode(lists[0].val);
            curr = curr.next;

            if (lists[0].next != null) {
                lists[0] = lists[0].next;
            } else {
                swap(1, n);
                --n;
            }
        }
        return root.next;
    }

    public ListNode mergeKListsByPQ(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode p, ListNode q) {
                if (p.val < q.val) return -1;
                if (p.val == q.val) return 0;
                return 1;
            }
        });
        ListNode root = new ListNode(0);
        ListNode curr = root;
        for (ListNode listNode : lists) {
            if (listNode != null) pq.add(listNode);
        }
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;

            if (curr.next != null) {
                pq.add(curr.next);
            }
        }
        return curr.next;
    }

}
