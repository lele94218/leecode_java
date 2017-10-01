package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/26/17 8:15 PM.
 */
public class BinarySearch {
    /**
     * Returns an index pointing to the first element in the array which compares greater than target.
     *
     * @param a
     * @param target
     * @return
     */
    int upper_bound_search(int a[], int target) {
        int low = 0, high = a.length, mid = 0;
        while (low < high) {
            mid = low + (high - low >>> 1);
            if (target >= a[mid]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * Returns an index pointing to the first element in the array which does not compare less than target.
     *
     * @param a
     * @param target
     * @return
     */
    int lower_bound_search(int a[], int target) {
        int low = 0, high = a.length, mid = 0;
        while (low < high) {
            mid = low + (high - low >>> 1);
            if (target <= a[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    int binary_search(int a[], int target) {
        int low = 0, high = a.length - 1, mid = 0;
        while (low <= high) {
            mid = low + (high - low >>> 1);
            if (target == a[mid]) {
                return mid;
            }
            if (target < a[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * A = {1, 2, 3}, T = 2, return 1
     * A = {1, 2, 3}, T = 4, return -1
     * A = {1, 2, 2, 2, 3}, T = 2, return 1
     *
     * @param array
     * @param target
     * @return
     */
    public int firstOccur(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0, right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left >>> 1);
            int midVal = array[mid];
            if (midVal >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (array[left] == target) return left;
        if (array[right] == target) return right;
        return -1;
    }

    /**
     * A = {1, 2, 3}, T = 2, return 1
     * A = {1, 2, 3}, T = 4, return -1
     * A = {1, 2, 2, 2, 3}, T = 2, return 3
     *
     * @param array
     * @param target
     * @return
     */
    public int lastOccur(int[] array, int target) {
        if (array == null || array.length == 0) return -1;
        int left = 0, right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left >>> 1);
            int midVal = array[mid];
            if (midVal <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (array[right] == target) return right;
        if (array[left] == target) return left;
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int a[] = new int[]{1, 2, 3, 4, 4, 4, 4, 6, 9};
        int r = -1;
        r = binarySearch.lower_bound_search(a, 1);
        System.out.println(r + " " + a[r]);
        r = binarySearch.upper_bound_search(a, 1);
        System.out.println(r + " " + a[r]);
    }
}
