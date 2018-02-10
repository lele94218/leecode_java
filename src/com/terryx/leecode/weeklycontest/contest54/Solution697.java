package com.terryx.leecode.weeklycontest.contest54;

import java.util.*;

/**
 * @author taoranxue on 2/9/18 7:23 PM.
 */
public class Solution697 {
    public int findShortestSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.get(nums[i]));
        }
        map = new HashMap<>();
        int begin = 0, end = 0, len = nums.length, cnt = 0;
        for (; end < nums.length; ++end) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            cnt = Math.max(cnt, map.get(nums[end]));
            while (begin <= end && cnt == max) {
                len = Math.min(len, end - begin + 1);
                if (map.containsKey(nums[begin]) && map.get(nums[begin]) == cnt) {
                    cnt--;
                }
                map.put(nums[begin], map.get(nums[begin]) - 1);
                begin++;

            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution697 m = new Solution697();
        System.out.println(m.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(m.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
