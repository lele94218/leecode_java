package com.terryx.leecode.problem;

import java.util.Collections;
import java.util.Stack;

/**
 * @author taoranxue on 10/20/16 9:27 PM.
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] > stack.peek()) {
                stack.push(nums[i]);
            } else {
                int low = 0, high = stack.size() - 1, target = nums[i];
                while (low < high) {
                    int mid = low + (high - low >>> 1);
                    int midVal = stack.get(mid);
                    if (target <= midVal) {
                        high = mid;
                    } else {
                        low = mid + 1;
                    }
                }
                stack.set(low, target);
            }
        }
        return stack.size() - 1;
    }
    public int lengthOfLIS1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MIN_VALUE);
        for (int num : nums) {
            if (num > stack.peek()) {
                stack.push(num);
            } else {
                int low = 0;
                int high = stack.size() - 1;
                while (low <= high) {
                    int mid = (low + high) >> 1;
                    if (stack.get(mid) < num) {
                        low = mid + 1;
                    } else if (stack.get(mid) > num) {
                        high = mid - 1;
                    } else {
                        low = mid;
                        break;
                    }
                }
                stack.set(low, num);
            }
        }
        return stack.size() - 1;
    }
}
