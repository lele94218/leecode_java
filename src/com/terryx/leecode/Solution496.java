package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/5/17 4:31 PM.
 */
public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; ++i) {
            map.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; ++i) {
            while (!stack.isEmpty()) {
                int front = stack.peek();
                if (nums2[i] > front) {
                    stack.pop();
                    nums1[map.get(front)] = nums2[i];
                } else {
                    break;
                }
            }
            if (map.containsKey(nums2[i])) {
                stack.push(nums2[i]);
            }
        }

        while (!stack.isEmpty()) {
            int front = stack.pop();
            nums1[map.get(front)] = -1;
        }
        return nums1;
    }
}
