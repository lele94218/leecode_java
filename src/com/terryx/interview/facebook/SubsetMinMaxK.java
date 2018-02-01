package com.terryx.interview.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/13/17 2:10 PM.
 */
public class SubsetMinMaxK {
    public int subsetMinMaxK(int nums[], int k) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1, cnt = 0;
        if (k > 0) cnt += 1;
        while (i <= j) {
            int sum = nums[i] + nums[j];
            if (sum < k) {
                cnt += (1 << (j - i));
                ++i;
            } else {
                --j;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        System.out.println(deque);
        deque.offerFirst(2);
        System.out.println(deque);
        deque.push(3);
        System.out.println(deque);
        deque.offer(4);
        System.out.println(deque);
        deque.pollFirst();
        System.out.println(deque);
        deque.offerLast(99);
        System.out.println(deque);
        System.out.println(deque.peek());

    }
}
