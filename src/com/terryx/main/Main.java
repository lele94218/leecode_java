package com.terryx.main;

import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }
        int l = 0, r = 0;
        for (int i = 0; i < n && a[i] <= 1 + Math.floor(999999.0 / 2.0); ++i) {
            l = a[i] - 1;
        }

        for (int j = n - 1; j >= 0 && a[j] >= 1000000 - Math.floor(999999.0 / 2.0); --j) {
            r = 1000000 - a[j];
        }

        System.out.println(Math.max(l, r));
    }


}
