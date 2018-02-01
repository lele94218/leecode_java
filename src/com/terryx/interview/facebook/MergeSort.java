package com.terryx.interview.facebook;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 10/19/17 7:26 PM.
 */
public class MergeSort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) {
            return;
        }
        int i = m - 1, j = n - 1, idx = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[idx--] = nums1[i--];
                } else {
                    nums1[idx--] = nums2[j--];
                }
            } else if (i >= 0) {
                nums1[idx--] = nums1[i--];
            } else {
                nums1[idx--] = nums2[j--];
            }
        }
    }

    //给两个数组找交集，不能重复。

    /**
     * Sort and two point. O(n log n + m log m + min(m, n)).
     */
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
        for (int idx = 0; idx < ans.size(); ++ idx) {
            ret[idx] = ans.get(idx);
        }
        return ret;
    }

    /**
     * 给一个partial sorted的数组比如{1, 3, 5, 2, 4, 6, 8, 10, 20, 30, 11, 12, 13}
     * 数组有N个数，分为M个segment，N>>>M，要求输出排序后的数组。
     */
    public int[] mergePartialSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int res[] = new int[nums.length];
        int idx = 0;
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return nums[a] - nums[b];
            }
        });
        queue.offer(0);
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int index = queue.poll();
            res[idx++] = nums[index];
            if (index + 1 < nums.length && nums[index + 1] >= nums[index]) {
                queue.offer(index + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MergeSort i = new MergeSort();
        System.out.println(Utils.debug(
                i.mergePartialSort(new int[]{1, 3, 5, 2, 4, 6, 8, 10, 20, 30, 11, 12, 13}
                )
        ));


        System.out.println(Utils.debug(
                i.mergePartialSort(new int[]{1}
                )
        ));


        System.out.println(Utils.debug(
                i.mergePartialSort(new int[]{9,8,7,6,5,4,3,2,1}
                )
        ));
    }
}
