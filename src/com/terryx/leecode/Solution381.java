package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/29/16 4:22 PM.
 */
public class Solution381 {
    public class RandomizedCollection {
        private Random random;
        private ArrayList<Integer> array;
        private HashMap<Integer, Set<Integer>> map;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            array = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean flag = map.containsKey(val);
            if (!flag) {
                map.put(val, new LinkedHashSet<>());
            }
            map.get(val).add(array.size());
            array.add(val);
            return !flag;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            boolean flag = map.containsKey(val);
            if (!flag) {
                return false;
            }
            int index = map.get(val).iterator().next();
            map.get(val).remove(index);
            if (index < array.size() - 1) {
                int lastValue = array.get(array.size() - 1);
                array.set(index, lastValue);
                map.get(lastValue).remove(array.size() - 1);
                map.get(lastValue).add(index);
            }
            array.remove(array.size() - 1);

            if (map.get(val).isEmpty()) map.remove(val);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return array.get(random.nextInt(array.size()));
        }
    }

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
}
