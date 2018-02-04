package com.terryx.leecode.problem;

import java.util.Stack;

/**
 * @author taoranxue on 10/17/16 6:20 PM.
 */
public class Solution71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Stack<String> output = new Stack<>();
        String[] paths = path.split("/");
        for (String s : paths) {
            if (s.equals("") || s.equals(".")) continue;
            if (s.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) return "/";
        while (!stack.isEmpty()) {
            output.push(stack.pop());
        }
        String res = "";
        while (!output.isEmpty()) {
            res += ("/" + output.pop());
        }
        return res;
    }
}
