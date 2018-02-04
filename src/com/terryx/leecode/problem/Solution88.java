package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/21/17 1:17 PM.
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;
        int i = m - 1, j = n - 1, index = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] >= nums2[j]) {
                    nums1[index--] = nums1[i--];
                } else {
                    nums1[index--] = nums2[j--];
                }
            } else if (i >= 0) {
                nums1[index--] = nums1[i--];
            } else {
                nums1[index--] = nums2[j--];
            }
        }
    }
}
