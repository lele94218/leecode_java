package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/12/17 6:47 PM.
 */
public class Solution170 {
    class TwoSum {
        Map<Integer, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            map = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            Integer v = map.get(number);
            if (v == null) {
                v = 0;
            }
            map.put(number, v + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (int num : map.keySet()) {
                if (value - num == num && map.get(num) != null && map.get(num) > 1) return true;
                if (value - num != num && map.get(num) != null && map.get(value - num) != null) return true;
            }
            return false;
        }
    }
}
