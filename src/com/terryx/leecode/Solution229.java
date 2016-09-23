package com.terryx.leecode;

import com.terryx.main.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author taoranxue on 9/23/16 12:46 AM.
 */
public class Solution229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> a = new ArrayList<>();
        if (nums.length <= 0) return a;
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
            System.out.println(Utils.debug(candidate1, candidate2, count1, count2));
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; ++ i) {
            if (nums[i] == candidate1) count1++;
            if (nums[i] == candidate2) count2++;
        }
        if (count1 > nums.length/3) a.add(candidate1);
        if (count2 > nums.length/3) a.add(candidate2);
        return a;
    }
}
