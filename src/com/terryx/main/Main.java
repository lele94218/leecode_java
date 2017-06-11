package com.terryx.main;

import com.terryx.leecode.contest35.Solution591;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main implements Cloneable {
    public static void main(String args[]) {
        Integer[] nums = {1,3,4};
        List<Integer> list = Arrays.asList(nums);
        System.out.println(Collections.binarySearch(list, 2));


    }


}
