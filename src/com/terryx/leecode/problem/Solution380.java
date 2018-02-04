package com.terryx.leecode.problem;

import java.util.HashMap;
import java.util.Random;

/**
 * @author taoranxue on 10/29/16 3:54 PM.
 */
public class Solution380 {
    public class RandomizedSet {
        private static final int MAX_MOUNT = 100000;
        private int size;
        private int array[];
        private HashMap<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            size = 0;
            array = new int[MAX_MOUNT];
            map = new HashMap<>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            array[size++] = val;
            map.put(val, size - 1);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            if (size > 1) {
                int index = map.get(val);
                int lastValue = array[--size];
                array[index] = lastValue;
                map.put(lastValue, index);
                map.remove(val);
            } else {
                map.remove(val);
                size--;
            }
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            if (size == 0) return -1;
            Random random = new Random();
            int index = Math.abs(random.nextInt()) % size;
            return array[index];
        }
    }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
