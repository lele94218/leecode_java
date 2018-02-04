package com.terryx.leecode.problem;

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

    class MinStack2 {

        Stack<Integer> values, min;
        int globalMin;

        public MinStack2() {
            values = new Stack<>();
            min = new Stack<>();
            globalMin = Integer.MIN_VALUE;
            min.push(globalMin);
            min.push(Integer.MAX_VALUE);
        }

        public int pop() {
            int e = values.pop(), cnt = min.pop();
            cnt--;
            if (cnt > 0) {
                min.push(cnt);
            } else {
                min.pop();
                cnt = min.pop();
                globalMin = min.peek();
                min.push(cnt);
            }
            return e;
        }

        public void push(int element) {
            values.push(element);
            if (min.size() == 2 || element < globalMin) {
                min.push(element);
                min.push(1);
                globalMin = element;
            } else {
                int cnt = min.pop();
                min.push(cnt + 1);
            }
        }

        public int top() {
            return values.peek();
        }

        public int getMin() {
            return globalMin;
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
