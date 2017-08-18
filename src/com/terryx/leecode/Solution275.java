package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/17/17 3:52 PM.
 */
public class Solution275 {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        // O(n)
        // int h = citations.length;
        // for (int i = 0; i < citations.length; ++ i) {
        //     if (citations[i] >= h) {
        //         break;
        //     }
        //     h--;
        // }
        // return h;

        // O(log n)
        int low = 0, high = citations.length;
        while (low < high) {
            // System.out.println(low + " " + high);
            int mid = low + (high - low + 1) / 2;
            int midVal = citations[citations.length - 1];
            if (mid > 0)
                midVal = citations[citations.length - mid];
            if (midVal >= mid) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
