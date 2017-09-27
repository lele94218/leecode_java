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

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int a[] = new int[]{1, 2, 3, 9};
        int r = -1;
        r = binarySearch.lower_bound_search(a, 5);
        System.out.println(r + " " + a[r]);
        r = binarySearch.upper_bound_search(a, 5);
        System.out.println(r + " " + a[r]);
    }
}
