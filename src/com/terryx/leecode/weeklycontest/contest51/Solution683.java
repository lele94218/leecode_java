package com.terryx.leecode.weeklycontest.contest51;

import java.util.*;

/**
 * @author taoranxue on 2/26/18 9:34 PM.
 */
public class Solution683 {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int day = 0;
        for (int flower : flowers) {
            day++;
            set.add(flower);
            Integer low = set.lower(flower), high = set.higher(flower);
            if ((low != null && flower - low - 1 == k) || (high != null && high - flower - 1 == k)) {
                return day;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution683 m = new Solution683();
        System.out.println(m.kEmptySlots(new int[]{1,2,3}, 1));
    }
}
