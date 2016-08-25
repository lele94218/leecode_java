package com.terryx.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xueta on 8/25/2016 8:25 AM.
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length - 2; ++i) {
            if (nums[i] > 0) break;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tmp = nums[i] + nums[j] + nums[k];
//                System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                if (tmp == 0) {
                    ansList.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
                if (tmp <= 0) {
                    while (nums[j] == nums[++j] && j < k) ;
                }
                if (tmp >= 0) {
                    while (nums[k] == nums[--k] && j < k) ;
                }
            }
            while (nums[i] == nums[i + 1] && i < nums.length - 2) {
                ++i;
            }
        }
        return ansList;
    }
}
