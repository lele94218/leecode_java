package com.terryx.leecode.problem;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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

        if (matrix == null || matrix.length == 0) return -1;
        int m = matrix.length, n = matrix[0].length;
        Queue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.val - b.val;
            }
        });

        for (int i = 0; i < n; ++i) {
            queue.offer(new Cell(0, i, matrix[0][i]));
        }

        for (int i = 0; i < k - 1; ++i) {
            Cell cur = queue.poll();
            if (cur.x + 1 < m) {
                queue.offer(new Cell(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
            }
        }
        return queue.peek().val;
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

    static class Cell {
        int x, y, val;

        Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public int kthSmallest0(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return -1;
        int m = matrix.length, n = matrix[0].length;
        boolean vist[][] = new boolean[m][n];
        Queue<Cell> queue = new PriorityQueue<>(new Comparator<Cell>() {
            public int compare(Cell a, Cell b) {
                return a.val - b.val;
            }
        });
        queue.offer(new Cell(0, 0, matrix[0][0]));
        vist[0][0] = true;
        for (int i = 0; i < k - 1; ++i) {
            Cell cur = queue.poll();
            int x = cur.x, y = cur.y;
            if (x + 1 < m && !vist[x + 1][y]) {
                queue.offer(new Cell(x + 1, y, matrix[x + 1][y]));
                vist[x + 1][y] = true;
            }
            if (y + 1 < n && !vist[x][y + 1]) {
                queue.offer(new Cell(x, y + 1, matrix[x][y + 1]));
                vist[x][y + 1] = true;
            }
        }
        return queue.peek().val;
    }

    // Binary Search O(log C * n * log n)
    public int kthSmallest1(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0], high = matrix[n - 1][n - 1];
        while (low < high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < n; ++ i) {
                int l = 0, h = n - 1;
                while (l < h) {
                    int m = (l + h + 1) / 2;
                    if (matrix[i][m] <= mid) {
                        l = m;
                    } else {
                        h = m - 1;
                    }
                }
                if (matrix[i][l] <= mid) {
                    count += l + 1;
                }
            }
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
