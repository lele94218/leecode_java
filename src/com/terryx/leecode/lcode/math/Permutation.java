package com.terryx.leecode.lcode.math;

import java.util.*;

/**
 * @author taoranxue on 9/27/17 11:51 PM.
 */
public class Permutation {

    /**
     * 1,3,2 -> 1,3,2
     * 9,2,2 -> 2,9,2
     * 1,3,1,2,4,7 -> 1,2,7,4,3,1
     *
     * @param nums number to array
     */
    public void prevPermutation(int nums[]) {
        if (nums == null || nums.length == 0) return;
        int index = -1;
        for (int i = nums.length - 1; i >= 1; --i) {
            if (nums[i - 1] > nums[i]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int smallerIdx = nums.length - 1;
        for (int i = index + 1; i < nums.length - 1; ++i) {
            if (nums[i] < nums[index] && nums[index] <= nums[i + 1]) {
                smallerIdx = i;
            }
        }

        swap(nums, index, smallerIdx);
        reverse(nums, index + 1, nums.length - 1);

    }

    /**
     * 1,3,2 -> 2,1,3
     * 9,2,2 -> 2,2,9
     * 1,3,1,2,4,7 -> 1,3,1,2,7,4
     *
     * @param nums number to array
     */
    public void nextPermutation(int nums[]) {
        if (nums == null) return;
        int index = -1;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        System.out.println(nums[index] + " " + index);

        int biggerIdx = index + 1;
        for (int i = index + 2; i < nums.length; ++i) {
            if (nums[i - 1] >= nums[index] && nums[index] > nums[i]) {
                biggerIdx = i - 1;
                break;
            }
        }
        swap(nums, biggerIdx, index);
        reverse(nums, index + 1, nums.length - 1);
    }

    private void swap(int nums[], int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int nums[], int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        int[] a1 = new int[]{1, 3, 1, 4, 5, 2, 1};
        permutation.prevPermutation(a1);
        for (int a : a1) {
            System.out.print(a + ",");
        }
        System.out.println();

        a1 = new int[]{1, 3, 1, 4, 5, 2, 1};
        permutation.nextPermutation(a1);
        for (int a : a1) {
            System.out.print(a + ",");
        }
        System.out.println();
    }

}
