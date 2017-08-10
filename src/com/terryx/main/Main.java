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
        int[] a = new int[]{0,1};
        int low = 0, high = a.length - 1, mid = 0, target = 1;
        while (low < high) {
            System.out.println(low + " " + high);
            mid = (low + high) / 2;
            if (target == a[mid]) {
                low = mid;
                break;
            }
            if (a[mid] < target) {
                low = mid;
            } else if (a[mid] > target) {
                high = mid - 1;
            }
        }

        System.out.println(low + ": " + a[low]);
    }

}
