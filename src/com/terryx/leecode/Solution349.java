package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/20/17 2:25 PM.
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> ans = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (i == 0 || j == 0 || !(nums1[i - 1] == nums2[j - 1] && nums1[i - 1] == nums1[i])) {
                    ans.add(nums1[i]);
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int ret[] = new int[ans.size()];
        for (int idx = 0; idx < ans.size(); ++idx) {
            ret[idx] = ans.get(idx);
        }
        return ret;
    }

    /**
     * Use hash table. O(m + n);
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        int[] tmp = null;
        if (nums1.length > nums2.length) {
            tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; ++i) {
            set.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; ++i) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * Binary search. O(n log n + m log n)
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        int[] tmp = null;
        if (nums1.length > nums2.length) {
            tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; ++i) {
            int target = nums1[i], left = 0, right = nums2.length - 1, mid = 0;
            while (left <= right) {
                mid = left + (right - left >> 1);
                int midVal = nums2[mid];
                if (target == midVal) {
                    left = mid;
                    break;
                }
                if (target < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left < nums2.length && target == nums2[left]) {
                set.add(target);
            }
        }
        int res[] = new int[set.size()], idx = 0;
        for (Integer num : set) {
            res[idx++] = num;
        }
        return res;
    }
}
