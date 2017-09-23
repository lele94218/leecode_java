package com.terryx.leecode.lcode.sort;

import java.util.*;

/**
 * @author taoranxue on 9/23/17 2:08 PM.
 */
public class MoveZeroToEnd {
    public int[] moveZero(int[] array) {
        // Write your solution here.
        int j = array.length - 1;
        for (int i = 0; i <= j; ++ i) {
            if (array[i] == 0) {
                swap(array, i-- , j--);
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
