package com.terryx.main;

import com.terryx.leecode.contest35.Solution591;
import com.terryx.leecode.contest42.Solution648;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {

    public static void main(String args[]) throws InterruptedException {
        int[] a = new int[]{1, 1, 1, 2, 3, 4, 4, 7, 7, 7};
        int low = 0, high = a.length - 1, mid = 0, target = 6;
        while (low < high) {
            mid = (low + high) / 2;
            if (target == a[mid]) {
                System.out.println("ok");
                break;
            }
            if (a[mid] < target) {
                low = mid + 1;
            } else if (a[mid] > target) {
                high = mid;
            }
        }

        System.out.println(low + ": " + a[low] + ", "
                + mid + ": " + a[mid] + ", "
                + high + ": " + a[high]);
    }

}
