package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/16/17 5:29 PM.
 */
public class Calculator {
    public int calculate(String s) {
        if (s == null) return 0;
        int res = 0, num = 0, sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (c == '(') {
                    stack.push(res);
                    stack.push(sign);
                    sign = 1;
                    res = 0;
                } else if (c == ')') {
                    res += sign * num;
                    res *= stack.pop();
                    res += stack.pop();
                } else {
                    res += sign * num;
                }
                num = 0;
                if (c == '+') {
                    sign = 1;
                } else if (c == '-') {
                    sign = -1;
                }
            }
        }
        return res;
    }
}
