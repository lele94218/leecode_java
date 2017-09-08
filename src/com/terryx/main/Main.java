package com.terryx.main;

import com.terryx.leecode.Solution151;
import com.terryx.leecode.contest35.Solution591;
import com.terryx.leecode.contest42.Solution648;
import com.terryx.leecode.contest48.Solution672;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public static void fun(Integer a, Integer b) {
        int tmp = a;
        a = new Integer(b);
        b = new Integer(tmp);
    }

    public static void fun1(String a, String b) {
        String tmp = a;
        a.trim();
        b.trim();
    }
    public static void main(String args[]) throws InterruptedException {
        Integer a = 3;
        Integer b = 4;
        fun(a, b);
        System.out.println(a + " " + b);
        String aa = "abc   ";
        String bb = "def   ";
        fun1(aa, bb);
        System.out.println(aa + " " + bb);
    }

}
