package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 9/8/17 12:58 PM.
 */
public class Solution592 {
    public String fractionAddition(String expression) {
        if (expression == null || expression.length() == 0) return "";
        List<Integer> nums = new ArrayList<>(), dens = new ArrayList<>();
        for (int i = 0; i < expression.length(); ) {
            int sign = 1;
            char c = expression.charAt(i);
            if (c == '+' || c == '-') {
                if (c == '-') sign = -1;
                i++;
            }
            int j = 0;
            for (j = i; j < expression.length() && expression.charAt(j) != '/'; ++j) ;
            nums.add(sign * Integer.parseInt(expression.substring(i, j)));
            i = j + 1;
            for (j = i; j < expression.length() && expression.charAt(j) != '-' && expression.charAt(j) != '+'; ++j) ;
            dens.add(Integer.parseInt(expression.substring(i, j)));
            i = j;
        }
        int den = 1;
        for (int i = 0; i < dens.size(); ++i) {
            den *= dens.get(i);
        }
        int num = 0;
        for (int i = 0; i < nums.size(); ++i) {
            num += nums.get(i) * (den / dens.get(i));
        }
        int g = gcd(Math.abs(num), den);
        return (num / g) + "/" + (den / g);
    }

    private int gcd(int a, int b) {
        while (a % b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return b;
    }
}
