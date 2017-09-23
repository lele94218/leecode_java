package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/23/17 2:03 PM.
 */
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here.
        int i = 0, j = 0, k = array.length - 1;
        while (j <= k) {
            if (array[j] == -1) {
                swap(array, i++, j++);
            } else if (array[j] == 0) {
                j++;
            } else if (array[j] == 1) {
                swap(array, k--, j);
            }
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
