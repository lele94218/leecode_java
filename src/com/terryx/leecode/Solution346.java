package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 3:37 PM.
 */
public class Solution346 {
    class MovingAverage {

        private Deque<Integer> queue;
        private int sum, size, cur;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            queue = new ArrayDeque<>();
            sum = 0;
            cur = 0;
            this.size = size;
        }

        public double next(int val) {
            cur++;
            sum += val;
            queue.offerFirst(val);
            if (cur > size) {
                sum -= queue.pollLast();
                cur--;
            }

            return (double) sum / cur;
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
}
