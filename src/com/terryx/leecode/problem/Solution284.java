package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/9/18 4:41 PM.
 */
public class Solution284 {
    // Java Iterator interface reference:
    // https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
    class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> itr;
        private Deque<Integer> cache;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.itr = iterator;
            cache = new ArrayDeque<>();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!cache.isEmpty()) {
                return cache.peek();
            }
            Integer t = itr.next();
            cache.offer(t);
            return t;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (!cache.isEmpty()) {
                return cache.poll();
            }
            return itr.next();
        }

        @Override
        public boolean hasNext() {
            return (!cache.isEmpty() || itr.hasNext());
        }
    }
}
