package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/17/17 3:02 PM.
 */
public class Solution274 {

    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        // O(n log n + n)
        // Arrays.sort(citations);
        // int h = citations.length;
        // for (int i = 0; i < citations.length; ++ i) {
        //     if (citations[i] >= h) {
        //         break;
        //     }
        //     h--;
        // }
        // return h;

        // O(n)
        int count[] = new int[citations.length + 1];
        for (int i = 0; i < citations.length; ++i) {
            int t = citations[i];
            if (t >= citations.length) {
                count[citations.length]++;
            } else {
                count[t]++;
            }
        }

        int h = citations.length, sum = 0;
        for (; h >= 0; --h) {
            sum += count[h];
            if (sum >= h) return h;
        }
        return 0;
    }
}
