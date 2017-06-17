package com.terryx.main;

import com.terryx.leecode.contest35.Solution591;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main implements Cloneable {

    public static int answer(int total_lambs) {

        // Your code goes here.
        int f1 = 1, f2 = 1;
        int a1 = 1;
        int fcnt = 1, acnt = 0;
        while ((2*f2 + f1 - 1) <= total_lambs) {
            int tmp = f2;
            f2 = f1 + f2;
            f1 = tmp;
            fcnt ++;
        }

        while ((2 * a1 - 1) <= total_lambs || (a1  >= 4 && a1/2 + a1/4 + a1 - 1 <= total_lambs)) {
            a1 *= 2;
            acnt ++;
        }
        System.out.println(fcnt + " " + acnt);
        return fcnt - acnt;

    }

    public static void main(String args[]) {
        System.out.println("m");
        System.out.println(answer(13));


    }


}
