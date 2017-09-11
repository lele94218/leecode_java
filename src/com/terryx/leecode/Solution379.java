package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 11:56 AM.
 */
public class Solution379 {
    class PhoneDirectory {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int next = 0, maxNumbers = -1;

        /**
         * Initialize your data structure here
         *
         * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
         */
        public PhoneDirectory(int maxNumbers) {
            this.maxNumbers = maxNumbers;
        }

        /**
         * Provide a number which is not assigned to anyone.
         *
         * @return - Return an available number. Return -1 if none is available.
         */
        public int get() {
            int ret = -1;
            if (!queue.isEmpty()) {
                ret = queue.poll();
            } else {
                if (next >= maxNumbers) return -1;
                ret = next++;
            }
            set.add(ret);
            return ret;
        }

        /**
         * Check if a number is available or not.
         */
        public boolean check(int number) {
            return !set.contains(number);
        }

        /**
         * Recycle or release a number.
         */
        public void release(int number) {
            if (set.contains(number)) {
                queue.offer(number);
                set.remove(number);
            }
        }
    }

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
}
