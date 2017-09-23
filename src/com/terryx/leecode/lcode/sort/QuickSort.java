package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/23/17 1:18 PM.
 */
public class QuickSort {
    public int[] quickSort(int[] array) {
        if (array == null || array.length == 0) return array;
        // Write your solution here
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = partition(array, left, right);
        quickSort(array, left, pivot - 1);
        quickSort(array, pivot + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivot = (int) (Math.random() * (right - left + 1)) + left, pn = array[pivot];
        swap(array, right, pivot);
        int i = left, j = right - 1;
        while (i <= j) {
            if (array[i] <= pn) {
                i++;
            } else if (array[j] > pn) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, right, i);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
