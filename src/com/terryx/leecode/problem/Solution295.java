package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/18/17 6:17 PM.
 */
public class Solution295 {
    class MedianFinder {
        Queue<Integer> smallQueue, largeQueue;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            smallQueue = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer a, Integer b) {
                    return b - a;
                }
            });
            largeQueue = new PriorityQueue<>();
        }

        public void addNum(int num) {
            smallQueue.offer(num);
            largeQueue.offer(smallQueue.poll());
            if (smallQueue.size() < largeQueue.size()) {
                smallQueue.offer(largeQueue.poll());
            }
        }

        public double findMedian() {
            if (smallQueue.size() == largeQueue.size()) {
                return (smallQueue.peek() + largeQueue.peek()) / 2.0;
            }
            return smallQueue.peek();
        }
    }
}
