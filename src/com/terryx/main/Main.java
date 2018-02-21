package com.terryx.main;

import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; ++i) {
            int x = in.nextInt();
            if (x == 0) {
                System.out.println("1 1");
                continue;
            }
            boolean find = false;
            for (int n = (int) Math.ceil(Math.sqrt((double) x)); n <= (int)Math.ceil(4.0 / 3.0 * Math.sqrt(x)); ++n) {
                //System.out.println(n);
                if (n * n - x == 0) {
                    continue;
                }
                int m = (int) Math.floor(n / Math.sqrt(n * n - x));
                if (m == 0) {
                    continue;
                }
                int k = (int) Math.floor(n / m);
                if (x == n * n - k * k) {
                    System.out.println(n + " " + m);
                    find = true;
                    break;
                }
            }
            if (!find)
                System.out.println(-1);
        }
    }
}
