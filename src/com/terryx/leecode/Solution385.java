package com.terryx.leecode;

import com.terryx.main.NestedInteger;

import java.util.*;

/**
 * @author taoranxue on 8/25/17 1:25 PM.
 */
public class Solution385 {
    // My Parser
//     private List<String> tokens;
//     private int ix = 0;
//     private String getToken() {
//         System.out.println(ix);
//         if (ix < tokens.size()) {
//             return tokens.get(ix++);
//         }
//         return "";
//     }

//     private NestedInteger primary() {
//         NestedInteger ret = new NestedInteger();
//         // System.out.println("ok");
//         NestedInteger n = null;
//         while(true) {
//             n = expression();
//             ret.add(n);
//             if (!",".equals(getToken())) {
//                 ix --;
//                 break;
//             }
//         }
//         return ret;
//     }

//     private NestedInteger expression() {
//         String cur = getToken();
//         int neg = 1;

//         if ("[".equals(cur)) {
//             if ("]".equals(getToken())) {
//                 return new NestedInteger();
//             } else {
//                 --ix;
//             }
//             NestedInteger n = primary();
//             getToken();
//             return n;
//         } else {
//             if ("-".equals(cur)) {
//                 neg = -1;
//             } else {
//                 ix --;
//             }

//             cur = getToken();
//             NestedInteger ret = new NestedInteger();
//             if (!"]".equals(cur)) {
//                 int num = Integer.parseInt(cur);
//                 num *= neg;
//                 ret.setInteger(num);
//             } else {
//                 ix --;
//             }
//             return ret;
//         }
//     }


//     public NestedInteger deserialize(String s) {
//         if (s == null || s.length() == 0) return new NestedInteger();
//         tokens = new ArrayList<>();
//         String st = "";
//         for (int i = 0; i < s.length(); ++ i) {
//             char c = s.charAt(i);
//             if (Character.isDigit(c)) {
//                 st += c;
//             }

//             if (c == '[' || c == ']' || c == ',' || c == '-' || i == s.length() - 1) {
//                 if (!"".equals(st)) {
//                     tokens.add(st);
//                     st = "";
//                 }
//                 if (!Character.isDigit(c))
//                     tokens.add(c + "");
//             }
//         }

//         for (int i = 0; i < tokens.size(); ++ i) {
//             System.out.println("####" + tokens.get(i) + "####");
//         }
//         NestedInteger res = expression();
//         if (res == null) {
//             return new NestedInteger();
//         }
//         return res;
//     }

    // Using stack
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) return new NestedInteger();
        int l = 0, r = 0;
        NestedInteger cur = null;
        Stack<NestedInteger> stack = new Stack<>();
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        for (; r < s.length(); ++ r) {
            char c = s.charAt(r);
            if (c == '[') {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = new NestedInteger();
                l = r + 1;
            } else if (c == ']') {
                String num = s.substring(l, r);
                if (!"".equals(num)) {
                    cur.add(new NestedInteger(Integer.parseInt(num)));
                }
                if (!stack.isEmpty()) {
                    stack.peek().add(cur);
                    cur = stack.pop();
                }
                l = r + 1;
            } else if (c == ',') {
                if (s.charAt(r - 1) != ']') {
                    cur.add(new NestedInteger(Integer.parseInt(s.substring(l, r))));
                }
                l = r + 1;
            }
        }
        return cur;
    }
}
