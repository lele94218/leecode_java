package com.terryx.leecode.problem;

import com.terryx.main.NestedInteger;

import java.util.*;

/**
 * @author taoranxue on 9/19/17 5:15 PM.
 */
public class Solution341 {
    public class NestedIterator implements Iterator<Integer> {
        private Stack<NestedInteger> stack;

        public NestedIterator(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; --i) stack.push(nestedList.get(i));
        }

        @Override
        public Integer next() {
            return stack.pop().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                NestedInteger cur = stack.peek();
                if (cur.isInteger()) {
                    return true;
                }
                stack.pop();
                for (int i = cur.getList().size() - 1; i >= 0; --i) stack.push(cur.getList().get(i));
            }
            return false;
        }
    }
}
