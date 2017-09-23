package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/23/17 1:19 PM.
 */
public class MergeSort {
    public int[] mergeSort(int[] array) {
        // Write your solution here.
        if (array == null || array.length == 0) return array;
        mergeSort(array, new int[array.length], 0, array.length - 1);
        return array;
    }

    private void mergeSort(int[] array, int[] helper, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left >> 1);
        mergeSort(array, helper, left, mid);
        mergeSort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right);
    }

    private void merge(int array[], int helper[], int left, int mid, int right) {
        for (int i = left; i <= right; ++i) {
            helper[i] = array[i];
        }
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (helper[i] < helper[j]) {
                array[left++] = helper[i++];
            } else {
                array[left++] = helper[j++];
            }
        }
        while (i <= mid) {
            array[left++] = helper[i++];
        }
    }
}
