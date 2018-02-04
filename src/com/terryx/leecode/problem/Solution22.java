package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author taoranxue on 10/25/16 9:28 PM.
 */
public class Solution22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, n, "");
        return res;
    }

    private void dfs(int open, int close, int max, String tmp) {
        if (tmp.length() >= 2 * max) {
            res.add(tmp);
            return;
        }
        if (open < max) {
            dfs(open + 1, close, max, tmp + "(");
        }
        if (close < open) {
            dfs(open, close + 1, max, tmp + ")");
        }
    }

    public List<String> generateParenthesisSlow(int n) {
        dfs(2 * n, n, n, new Stack<>(), new ArrayList<>());
        return res;
    }

    private void dfs(int n, int left, int right, Stack<Integer> stack, List<Integer> tmp) {
        if (left < 0 || right < 0) return;
        if (n <= 0 && stack.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Integer a : tmp) {
                sb.append(a == 0 ? "(" : ")");
            }
            res.add(sb.toString());
            return;
        }
        tmp.add(0);
        stack.push(0);
        dfs(n - 1, left - 1, right, stack, tmp);
        stack.pop();
        tmp.remove(tmp.size() - 1);


        tmp.add(1);
        if (!stack.isEmpty() && stack.peek() == 0) {
            stack.pop();
            dfs(n - 1, left, right - 1, stack, tmp);
            stack.push(0);
        } else {
            stack.push(1);
            dfs(n - 1, left, right - 1, stack, tmp);
            stack.pop();
        }
        tmp.remove(tmp.size() - 1);

    }


}
