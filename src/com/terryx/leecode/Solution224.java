package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/23/17 4:32 PM.
 */
public class Solution224 {
    List<String> tokens;
    int ix = 0;

    private String getToken() {
        if (ix < tokens.size()) return tokens.get(ix++);
        return "";
    }

    private int expression() {
        int v1 = term();
        while (true) {
            String cur = getToken();
            if (!cur.equals("+") && !cur.equals("-")) {
                --ix;
                break;
            }
            int v2 = term();
            if (cur.equals("+")) {
                v1 += v2;
            } else if (cur.equals("-")) {
                v1 -= v2;
            }
        }
        return v1;
    }

    private int term() {
        int v1 = primary();
        while (true) {
            String cur = getToken();
            if (!cur.equals("*") && !cur.equals("/")) {
                --ix;
                break;
            }
            int v2 = primary();
            if (cur.equals("*")) {
                v1 *= v2;
            } else if (cur.equals("/")) {
                v1 /= v2;
            }
        }
        return v1;
    }

    private int primary() {
        int v = 0, neg = 1;
        if (getToken().equals("-")) {
            neg = -1;
        } else {
            --ix;
        }
        String cur = getToken();
        if (cur.equals("(")) {
            v = expression();
            getToken();
        } else {
            v = Integer.parseInt(cur);
        }

        return v * neg;
    }

    public int calculate(String s) {

        if (s == null || s.length() == 0) return 0;
        tokens = new ArrayList<>();
        Set set = new HashSet<>();
        String st = "";
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                st += c;
            } else if (c == '+' || c == '-' || c == '*' || c == '/' ||
                    c == '-' || c == '(' || c == ')') {
                if (!st.equals(""))
                    tokens.add(new String(st));
                tokens.add(c + "");
                st = "";
            }

            if (i == s.length() - 1)
                tokens.add(new String(st));
        }

        // for (String str : tokens) {
        //     System.out.println("----" + str + "----");
        // }
        return expression();
    }

    public int calculate0(String s) {
        if (s == null) return 0;
        int res = 0, num = 0, sign = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++ i) {
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
