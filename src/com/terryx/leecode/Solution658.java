package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/30/17 5:33 PM.
 */
public class Solution658 {
    private int leftStart = -1, rightStart = -1;

    public List<Integer> findClosestElements(int[] array, int k, int target) {
        if (array == null || array.length == 0) return new ArrayList<>(0);
        int left = 0, right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left >>> 1);
            int midVal = array[mid];
            if (midVal <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        helper(array, left, right, k, target);
        List<Integer> ans = new ArrayList<>();
        if (leftStart >= 0) {
            for (int i = leftStart; i < leftStart + k; ++i) {
                ans.add(array[i]);
            }
        } else {
            for (int i = rightStart - k + 1; i <= rightStart; ++i) {
                ans.add(array[i]);
            }
        }
        return ans;
    }

    private void helper(int array[], int aleft, int bleft, int k, int target) {
        if (aleft < 0) {
            rightStart = bleft + k - 1;
            return;
        }
        if (bleft >= array.length) {
            leftStart = aleft - k + 1;
            return;
        }
        if (k == 1) {
            if (Math.abs(target - array[aleft]) <= Math.abs(target - array[bleft])) {
                leftStart = aleft;
            } else {
                rightStart = bleft;
            }
            return;
        }
        int amid = aleft - k / 2 + 1, bmid = bleft + k / 2 - 1;
        int aval = amid >= 0 ? Math.abs(target - array[amid]) : Integer.MAX_VALUE;
        int bval = bmid < array.length ? Math.abs(target - array[bmid]) : Integer.MAX_VALUE;
        if (aval <= bval) {
            helper(array, amid - 1, bleft, k - k / 2, target);
        } else {
            helper(array, aleft, bmid + 1, k - k / 2, target);
        }
    }
}
