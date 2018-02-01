package com.terryx.interview.facebook;

import com.terryx.main.NestedInteger;

import java.util.*;

/**
 * @author taoranxue on 10/20/17 4:16 PM.
 */
public class FlattenNestedList {

    Deque<NestedInteger> stack = new ArrayDeque<>();
    /**
     * Iterative.
     */
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        List<Integer> res = new ArrayList<>();
        if (nestedList == null) {
            return res;
        }
        pushAll(nestedList);
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) {
                res.add(stack.pop().getInteger());
            } else {
                pushAll(stack.pop().getList());
            }
        }
        return res;
    }

    private void pushAll(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; --i) {
            stack.push(list.get(i));
        }
    }

    /**
     * Recursive
     */
    public List<Integer> flatten1(List<NestedInteger> nestedList) {
        List<Integer> ans = new ArrayList<>();
        dfs(nestedList, ans);
        return ans;
    }

    private void dfs(List<NestedInteger> list, List<Integer> ans) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); ++ i) {
            if (list.get(i).isInteger()) {
                ans.add(list.get(i).getInteger());
            } else {
                dfs(list.get(i).getList(), ans);
            }
        }
    }
}
