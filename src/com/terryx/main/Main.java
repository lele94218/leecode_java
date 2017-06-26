package com.terryx.main;

import com.terryx.leecode.contest35.Solution591;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 2;

    private static int identify(String ip) {
        String[] seg = ip.split("\\.");
        int a = Integer.parseInt(seg[0]);

        if (a <= 127 && a >= 0) return A;
        if (a <= 191 && a >= 128) return B;
        if (a <= 233 && a >= 192) return C;
        return -1;
    }

    public static void main(String args[]) {
        System.out.println(identify("192.168.1.1"));
        System.out.println(identify("192.e168.1.122"));
    }

}
