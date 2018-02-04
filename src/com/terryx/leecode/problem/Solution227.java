package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/23/17 4:21 PM.
 */
public class Solution227 {
    List<String> tokens;
    int ix = 0;
    private String getToken() {
        if (ix < tokens.size()) return tokens.get(ix++);
        return "";
    }
    private int expression() {
        int v1 = term();
        while(true) {
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
        int v1 = Integer.parseInt(getToken());
        while(true) {
            String cur = getToken();
            if (!cur.equals("*") && !cur.equals("/")) {
                --ix;
                break;
            }
            int v2 = Integer.parseInt(getToken());
            if (cur.equals("*")) {
                v1 *= v2;
            } else if (cur.equals("/")) {
                v1 /= v2;
            }
        }
        return v1;
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        tokens = new ArrayList<>();

        String st = "";
        for (int i = 0; i < s.length(); ++ i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                st += c;
            } else if (c == '+' || c == '-' || c== '*' || c == '/' ) {
                tokens.add(new String(st));
                tokens.add(c + "");
                st = "";
            }

            if (i == s.length() - 1)
                tokens.add(new String(st));
        }
        return expression();
    }

    /**
     * Stack version
     */
    public int calculate0(String s) {
        if (s == null) return 0;
        int res = 0, num = 0;
        char sign = '+';
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++ i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
