package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/8/18 10:10 PM.
 */
public class Solution683 {
    public int kEmptySlots(int[] flowers, int k) {
        if (flowers == null || flowers.length == 0) {
            return -1;
        }
        TreeSet<Integer> set = new TreeSet<>();
        int day = 0;
        for (int i = 0; i < flowers.length; ++i) {
            day++;
            int bloom = flowers[i];
            set.add(bloom);
            Integer left = set.lower(bloom);
            Integer right = set.higher(bloom);
            if (left != null && bloom - left - 1 == k || right != null && right - bloom - 1 == k) {
                return day;
            }
        }
        return -1;
    }
}
