package com.terryx.leecode;

import java.util.PriorityQueue;

/**
 * @author taoranxue on 9/29/16 3:34 PM.
 */
public class Solution264 {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        for (int i = 1; i < n; ++ i) {
            long tmp = pq.poll();
            while (!pq.isEmpty() && tmp == pq.peek()) {
                tmp = pq.poll();
            }
            pq.offer(tmp * 2);
            pq.offer(tmp * 3);
            pq.offer(tmp * 5);
        }
        return pq.peek().intValue();
    }
}
