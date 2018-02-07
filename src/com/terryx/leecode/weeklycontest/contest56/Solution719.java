package com.terryx.leecode.weeklycontest.contest56;

import java.util.*;

/**
 * @author taoranxue on 2/6/18 11:45 PM.
 */
public class Solution719 {

    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int low = 0, high = nums[nums.length - 1] - nums[0];
        while (low < high) {
            int mid = (low + high) / 2;
            int begin = 0, end = 0, cnt = 0;
            for (; end < nums.length; ++end) {
                while (nums[end] - nums[begin] > mid) {
                    begin ++;
                }
                cnt += end - begin;
            }
            if (cnt >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        Solution719 m = new Solution719();
        System.out.println(m.smallestDistancePair(new int[]{1, 3, 1}, 1));
        System.out.println(m.smallestDistancePair(new int[]{1, 3, 1}, 2));
        System.out.println(m.smallestDistancePair(new int[]{1, 3, 1}, 3));
        System.out.println(m.smallestDistancePair(new int[]{1, 3, 1}, 4));
        System.out.println(m.smallestDistancePair(new int[]{62, 100, 4}, 2));
    }
}
