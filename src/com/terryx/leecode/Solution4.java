package com.terryx.leecode;

/**
 * @author taoranxue on 9/26/16 6:23 PM.
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            m = nums1.length;
            n = nums2.length;
        }
        int left = 0, right = m;
        int i, j;
        while (left <= right) {
            i = left + (right - left) / 2;
            j = (m + n + 1) / 2 - i;
            System.out.println(i + " " + j);
            if (i > 0 && j < n && nums1[i - 1] > nums2[j]) {
                right = i - 1;
            } else if (j > 0 && i < m && nums2[j - 1] > nums1[i]) {
                left = i + 1;
            } else {
                int maxLeft;
                if (i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);

                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m)
                    minRight = nums2[j];
                else if (j == n)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
