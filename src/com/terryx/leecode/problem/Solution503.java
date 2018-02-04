package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/5/17 5:11 PM.
 */
public class Solution503 {
    //     class T {
//         int val = 0;
//         int index = -1;
//         T(int val, int index) {
//             this.val = val;
//             this.index = index;
//         }
//     }

//     public int[] nextGreaterElements(int[] nums) {
//         if (nums == null || nums.length == 0) return new int[0];
//         Stack<T> stack = new Stack<>();
//         int res[] = new int[nums.length];
//         for (int i = 0; i < 2 * nums.length - 1; ++ i) {
//             int idx = i % nums.length;
//             while (!stack.isEmpty()) {
//                 T front = stack.peek();
//                 if (nums[idx] > front.val) {
//                     res[front.index] = nums[idx];
//                     stack.pop();
//                 } else {
//                     break;
//                 }
//             }

//             if (i < nums.length) {
//                 stack.push(new T(nums[i], i));
//             }
//         }

//         while (!stack.isEmpty()) {
//             T front = stack.pop();
//             res[front.index] = -1;
//         }


    //         return res;
//     }
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        int res[] = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            int idx = i % nums.length;
            while (!stack.isEmpty() && nums[idx] >= nums[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[idx] = nums[stack.peek()];
            } else {
                res[idx] = -1;
            }
            stack.push(idx);
        }
        return res;
    }
}
