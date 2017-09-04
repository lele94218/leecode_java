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

    public static void main(String args[]) throws InterruptedException {
        for (int i = 1; i <= 6; i ++) {
            for (int j = 1; j <= 20; ++ j) {

                System.out.println(new Solution672().flipLights(i , j));
            }
        }
    }

}
