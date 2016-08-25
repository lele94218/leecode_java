package com.terryx.leecode;

import java.util.Arrays;

/**
 * @author xueta on 8/25/2016 7:25 AM.
 */
public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; ++i) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
//                System.out.println(i + " " + j + " " + k + "-->" + ans + " " + tmp);
                if (tmp - target > 0) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(tmp - target) < Math.abs(ans - target)) ans = tmp;
                if (ans == target) return target;
            }
        }
        return ans;
    }
}
