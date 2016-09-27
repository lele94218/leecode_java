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

    public class Heap {
        ListNode[] queue;
        int size = 0;

        public Heap(int n) {
            queue = new ListNode[n];
        }

        public void add(ListNode listNode) {
            int i = size;
            size = i + 1;
            if (i == 0) {
                queue[0] = listNode;
            }
            else {
                siftUp(i, listNode);
            }
        }

        public ListNode poll() {
            System.out.println(size);
            if (size == 0) return null;
            int s = --size;
            ListNode result = queue[0];
            ListNode x = queue[s];
            queue[s] = null;
            if (s != 0) siftDown(0, x);
            return result;
        }

        private void siftDown(int k, ListNode x) {
            int half = size >> 1;
            while (k < half) {
                int child = (k << 1) + 1;
                ListNode c = queue[child];
                int right = child + 1;
                if (right < size && c.val > queue[right].val) c = queue[child = right];
                if (queue[child].val >= x.val) break;
                queue[k] = c;
                k = child;
            }
            queue[k] = x;
        }

        private void siftUp(int k, ListNode x) {
            while (k > 0) {
                int parent = (k - 1) >> 1;
                ListNode e = queue[parent];
                if (e.val <= x.val) break;
                queue[k] = e;
                k = parent;
            }
            queue[k] = x;
        }

        public boolean isEmpty() {
            return size <= 0;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        Heap heap = new Heap(n);
        ListNode root = new ListNode(0);
        ListNode curr = root;
        for (ListNode listNode : lists) {
            if (listNode != null) heap.add(listNode);
        }
        while (!heap.isEmpty()) {
            System.out.println("ok");
            curr.next = heap.poll();
            curr = curr.next;
            if (curr.next != null) {
                heap.add(curr.next);
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
        return root.next;
    }

}
