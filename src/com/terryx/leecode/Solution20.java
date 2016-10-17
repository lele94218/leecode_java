package com.terryx.leecode;

import java.util.Stack;

/**
 * @author taoranxue on 10/15/16 7:56 PM.
 */
public class Solution20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++ i) {
            if (s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {

            }
        }
    }
}
