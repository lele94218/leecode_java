package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/30/17 6:52 PM.
 */
public class KthProblem {
    /**
     * Given two sorted arrays of integers, find the Kth smallest number.
     * Assumptions
     * The two given arrays are not null and at least one of them is not empty
     * K >= 1, K <= total lengths of the two sorted arrays
     * <p>
     * Examples
     * A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.
     * A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.
     *
     * @param a
     * @param b
     * @param k
     * @return
     */
    public int kthSmallestOfTwoArrays(int a[], int b[], int k) {
        return helper(a, 0, b, 0, k);
    }

    private int helper(int a[], int aleft, int b[], int bleft, int k) {
        if (aleft == a.length) {
            return b[bleft + k - 1];
        }
        if (bleft == b.length) {
            return a[aleft + k - 1];
        }
        if (k == 1) {
            return Math.min(a[aleft], b[bleft]);
        }
        int amid = aleft + k / 2 - 1, bmid = bleft + k / 2 - 1;
        int aval = amid < a.length ? a[amid] : Integer.MAX_VALUE;
        int bval = bmid < b.length ? b[bmid] : Integer.MAX_VALUE;
        if (aval <= bval) {
            return helper(a, amid + 1, b, bleft, k - k / 2);
        } else {
            return helper(a, aleft, b, bmid + 1, k - k / 2);
        }
    }

    /**
     * Find the K smallest numbers in an unsorted integer array A. The returned numbers should be in ascending order.
     * <p>
     * </>Assumptions
     * <p>
     * A is not null
     * K is >= 0 and smaller than or equal to size of A
     * Return
     * <p>
     * an array with size K containing the K smallest numbers in ascending order
     * Examples
     * <p>
     * A = {3, 4, 1, 2, 5}, K = 3, the 3 smallest numbers are {1, 2, 3}
     */

    /**
     * k + (n - k)log k, Max heap
     */
    public int[] kSmallest0(int[] array, int k) {
        int ans[] = new int[k];
        if (array == null || array.length == 0 || k == 0) return ans;
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (int i = 0; i < k; ++i) {
            queue.offer(array[i]);
        }

        for (int i = k; i < array.length; ++i) {
            if (array[i] < queue.peek()) {
                queue.poll();
                queue.offer(array[i]);
            }
        }

        for (int i = k - 1; i >= 0; --i) {
            ans[i] = queue.poll();
        }

        return ans;
    }

    /**
     * Quick Select: Average: O(n + k log k), Worst: O(n^2 + k log k)
     */
    public int[] kSmallest1(int[] array, int k) {
        int ans[] = new int[k];
        if (array == null || array.length == 0 || k == 0) return ans;
        quickSelect(array, 0, array.length - 1, k - 1);
        ans = Arrays.copyOf(array, k);
        Arrays.sort(ans);
        return ans;
    }

    private void quickSelect(int[] array, int left, int right, int k) {
        if (left > right) return;
        int pivot = partition(array, left, right);
        if (k == pivot) return;
        if (k < pivot) {
            quickSelect(array, left, pivot - 1, k);
        } else {
            quickSelect(array, pivot + 1, right, k);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = right, pivotVal = array[right];
        int i = left, j = right - 1;
        while (i <= j) {
            if (array[i] < pivotVal) {
                i++;
            } else if (array[j] >= pivotVal) {
                j--;
            } else {
                swap(array, i++, j--);
            }
        }
        swap(array, i, pivot);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
