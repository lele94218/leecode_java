package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/23/17 1:19 PM.
 */
public class SelectSort {
    public int[] solve(int[] array) {
        // Write your solution here.
        if (array == null || array.length == 0) return array;
        for (int i = 0; i < array.length; ++i) {
            int min = i;
            for (int j = i; j < array.length; ++j) {
                if (array[j] < array[min]) min = j;
            }
            swap(array, i, min);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
