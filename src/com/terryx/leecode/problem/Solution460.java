package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/12/18 12:45 AM.
 */
public class Solution460 {

    class LFUCache {

        private Map<Integer, Integer> keyToCount, keyToValue;
        private Map<Integer, LinkedHashSet<Integer>> countToKeyList;
        int capacity, min;

        public LFUCache(int capacity) {
            min = 0;
            keyToCount = new HashMap<>();
            keyToValue = new HashMap<>();
            countToKeyList = new HashMap<>();
            this.capacity = capacity;
        }


        public int get(int key) {
            if (!keyToValue.containsKey(key)) {
                return -1;
            }
            int count = keyToCount.get(key);
            if (count == min && countToKeyList.get(count).size() == 1) {
                min++;
            }
            keyToCount.remove(key);
            keyToCount.put(key, count + 1);
            countToKeyList.get(count).remove(key);
            if (!countToKeyList.containsKey(count + 1)) {
                countToKeyList.put(count + 1, new LinkedHashSet<>());
            }
            countToKeyList.get(count + 1).add(key);
            return keyToValue.get(key);
        }

        public void put(int key, int value) {
            if (capacity <= 0) {
                return;
            }
            if (keyToValue.containsKey(key)) {
                keyToValue.put(key, value);
                get(key);
                return;
            }
            if (keyToValue.size() >= capacity) {
                int victim = countToKeyList.get(min).iterator().next();
                countToKeyList.get(min).remove(victim);
                keyToValue.remove(victim);
            }
            min = 1;
            keyToCount.put(key, min);
            if (!countToKeyList.containsKey(min)) {
                countToKeyList.put(min, new LinkedHashSet<>());
            }
            countToKeyList.get(min).add(key);
            keyToValue.put(key, value);
        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
