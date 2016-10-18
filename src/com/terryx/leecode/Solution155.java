package com.terryx.leecode;

import java.util.Stack;

/**
 * @author taoranxue on 10/17/16 2:20 AM.
 */
public class Solution155 {
    public class MinStack {
        private Stack<Long> stack = new Stack<>();
        private int min;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(0L);
                min = x;
            } else {
                stack.push((long) x - min);
                min = Math.min(min, x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) return;
            long c = stack.pop();
            if (c < 0L) min = (int) (min - c);
        }

        public int top() {
            long c = stack.peek();
            if (c > 0L)
                return (int) (min + c);
            return getMin();
        }

        public int getMin() {
            return (int) min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
