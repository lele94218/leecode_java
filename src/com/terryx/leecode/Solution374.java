package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/30/17 2:09 AM.
 */
public class Solution374 {
    private int guess(int v) {
        return -1;
    }

    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = guess(mid);
            if (midVal == 0) {
                return mid;
            }
            if (midVal == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            // System.out.println(low + " " + high);
        }
        return -1;
    }
}
