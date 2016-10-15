package com.terryx.leecode;

import java.util.PriorityQueue;

/**
 * @author taoranxue on 10/15/16 6:26 PM.
 */
public class Solution378 {
    private int size = 0;

    private int poll(int[] heap) {
        if (size == 0) return Integer.MIN_VALUE;
        int s = --size;
        int result = heap[0];
        int x = heap[s];
        heap[s] = Integer.MIN_VALUE;
        if (s > 0) siftDown(heap, 0, x);
        return result;
    }

    private void siftDown(int[] heap, int k, int x) {
        int half = size >> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            int c = heap[child];
            int right = child + 1;
            if (right < size && heap[right] < c) c = heap[child = right];
            if (c >= x) break;
            heap[k] = c;
            k = child;
        }
        heap[k] = x;
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int j = 0; j < n; ++ j) {
            pq.offer(new Pair(0, j, matrix[0][j]));
        }
        int result = -1;
        for (int i = 0; i < k; ++ i) {
            Pair tmp = pq.poll();
            result = tmp.val;
            if (tmp.x + 1 < n)
                pq.offer(new Pair(tmp.x + 1, tmp.y, matrix[tmp.x + 1][tmp.y]));
        }
        return result;
    }

    class Pair implements Comparable<Pair> {
        int x;
        int y;
        int val;

        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Pair other) {
            return this.val - other.val;
        }
    }
}
