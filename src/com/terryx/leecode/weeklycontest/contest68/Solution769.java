package com.terryx.leecode.weeklycontest.contest68;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 9:49 PM.
 */
public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int start = 0, cnt = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; ++i) {
            queue.offer(arr[i]);
            //System.out.println(queue);
            if (start == queue.peek()) {
                int max = 0;
                for (Integer a : queue) {
                    max = Math.max(max, a);
                }
                if (max == i) {
                    //System.out.println("ok");
                    start = i + 1;
                    cnt++;
                    while (!queue.isEmpty()) {
                        queue.poll();
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution769 m = new Solution769();
        System.out.println(m.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        System.out.println(m.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        System.out.println(m.maxChunksToSorted(new int[]{0, 1, 2, 3, 4}));
        System.out.println(m.maxChunksToSorted(new int[]{0}));
        System.out.println(m.maxChunksToSorted(new int[]{2, 0, 1, 3}));
    }
}
