package com.terryx.leecode.contest39;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author taoranxue on 7/1/17 10:40 PM.
 */
public class Solution632 {
    class Node {
        int i;
        int j;
        int num;

        public Node(int i, int j, int num) {
            this.i = i;
            this.j = j;
            this.num = num;
        }
    }

    public int[] smallestRange(int[][] nums) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                return a.num - b.num;
            }
        });
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; ++i) {
            queue.offer(new Node(i, 0, nums[i][0]));
            max = Math.min(max, nums[i][0]);
        }
        int range = Integer.MAX_VALUE;
        int start = 0, end = 0;
        for (; ; ) {
            Node cur = queue.peek();
            min = cur.num;
            if (range > max - min + 1) {
                range = max - min + 1;
                start = min;
                end = max;
            }

            int _num;
            if (cur.j + 1 < nums[cur.i].length) {
                _num = nums[cur.i][cur.j + 1];
                if (_num > max) {
                    max = _num;
                }
            } else {
                break;
            }

            queue.poll();
            queue.offer(new Node(cur.i, cur.j + 1, _num));
        }

        return new int[]{start, end};
    }
}
