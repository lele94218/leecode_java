package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/13/17 4:40 PM.
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int ans[] = new int[nums.length - k + 1];
        if (nums == null || nums.length == 0 || k <= 0) return new int[0];
        int p = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!deque.isEmpty() && i - k >= deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) { // If min value change '<' to '>'
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i + 1 >= k) {
                ans[p++] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
