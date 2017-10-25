package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/23/17 11:09 PM.
 */
public class Solution384 {
    class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return nums;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            Random r = new Random();
            if (nums == null || nums.length == 0) {
                return nums;
            }
            int a[] = nums.clone();
            for (int i = a.length - 1; i >= 0; --i) {
                int idx = r.nextInt(i + 1);
                swap(a, idx, i);
            }
            return a;
        }

        private void swap(int a[], int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
