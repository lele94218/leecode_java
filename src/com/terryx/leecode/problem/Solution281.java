package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/27/17 2:13 PM.
 */
public class Solution281 {
    public class ZigzagIterator {
        Queue<Iterator> indexQueue;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            indexQueue = new LinkedList<>();
            if (v1.size() > 0) indexQueue.offer(v1.iterator());
            if (v2.size() > 0) indexQueue.offer(v2.iterator());
        }

        public int next() {
            Iterator<Integer> it = indexQueue.poll();
            int res = it.next();
            if (it.hasNext()) indexQueue.offer(it);
            return res;
        }

        public boolean hasNext() {
            return !indexQueue.isEmpty();
        }
    }

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
