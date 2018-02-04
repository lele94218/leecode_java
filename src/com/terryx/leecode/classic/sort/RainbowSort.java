package com.terryx.leecode.classic.sort;

/**
 * @author taoranxue on 9/23/17 2:03 PM.
 */
public class RainbowSort {
    public int[] rainbowSort(int[] array) {
        // Write your solution here.
        int i = 0, j = 0, k = array.length - 1;
        while (j <= k) {
            System.out.println(i + " " + j + " " + k);
            if (array[j] == 0) {
                j++;
            }
            if (j <= k) {
                if (array[j] == -1) {
                    swap(array, i++, j++);
                }
                if (array[j] == 1) {
                    swap(array, k--, j);
                }
            }

            System.out.println(i + " " + j + " " + k);
        }
        return array;
    }

    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        RainbowSort rainbowSort = new RainbowSort();
        int array[] = new int[]{1, -1};
        rainbowSort.rainbowSort(array);
        for (int i = 0; i < array.length; ++ i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
