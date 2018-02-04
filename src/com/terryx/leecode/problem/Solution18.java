package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xueta on 8/25/2016 9:31 AM.
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    int tmp = nums[i] + nums[j] + nums[k] + nums[l];
                    if (tmp == target) {
                        ansList.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                    }
                    if (tmp >= target) {
                        while (nums[l] == nums[--l] && k < l) ;
                    }
                    if (tmp <= target) {
                        while (nums[k] == nums[++k] && k < l) ;
                    }
                }
                while (nums[j] == nums[++j] && j < nums.length - 2) ;
            }
            while (nums[i] == nums[++i] && i < nums.length - 1) ;
        }
        return ansList;
    }
}
