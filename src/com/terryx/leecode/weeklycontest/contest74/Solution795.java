package com.terryx.leecode.weeklycontest.contest74;

import java.util.*;

/**
 * @author taoranxue on 3/3/18 10:36 PM.
 */
public class Solution795 {
    public int numSubarrayBoundedMax(int[] nums, int L, int R) {
        int len = 0, cnt = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] <= R) {
                len++;
            } else {
                cnt += (len + 1) * len / 2;
                len = 0;
            }
        }
        cnt += (len + 1) * len / 2;

        len = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < L) {
                len++;
            } else {
                cnt -= (len + 1) * len / 2;
                len = 0;
            }
        }
        cnt -= (len + 1) * len / 2;
        return cnt;
    }

    public static void main(String[] args) {
        Solution795 m = new Solution795();
        System.out.println(m.numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
        System.out.println(m.numSubarrayBoundedMax(new int[]{4, 2, 4, 3}, 2, 3));
        System.out.println(m.numSubarrayBoundedMax(new int[]{2, 9, 2, 5, 6}, 2, 8));
    }
}
