package com.terryx.leecode.lcode.stack;

import java.util.*;

/**
 * @author taoranxue on 10/1/17 2:47 PM.
 */
public class MinStack {
    /**
     * with two stacks.
     */
    class Solution1 {

        Stack<Integer> values, min;
        int globalMin;

        public Solution1() {
            values = new Stack<>();
            min = new Stack<>();
            globalMin = Integer.MIN_VALUE;
            min.push(-1);
            min.push(Integer.MAX_VALUE);
        }

        public int pop() {
            if (values.isEmpty()) return -1;
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
            if (values.isEmpty()) return -1;
            return values.peek();
        }

        public int min() {
            if (values.isEmpty()) return -1;
            return globalMin;
        }
    }

    /**
     * with one stack
     */
    public class Solution2 {
        Stack<Integer> stack;
        int globalMin;
        public Solution2() {
            // write your solution here
            stack = new Stack<Integer>();
            globalMin = Integer.MAX_VALUE;
        }

        public int pop() {
            if (stack.isEmpty())
                return -1;
            if (stack.peek() < 0) {
                int ret = globalMin;
                globalMin = globalMin - stack.pop();
                return ret;
            }
            return stack.pop();
        }

        public void push(int element) {
            if (element < globalMin) {
                stack.push(element - globalMin);
                globalMin = element;
            } else {
                stack.push(element);
            }
        }

        public int top() {
            if (stack.isEmpty())
                return -1;
            if (stack.peek() < 0) return globalMin;
            return stack.peek();
        }

        public int min() {
            if (stack.isEmpty())
                return -1;
            return globalMin;
        }
    }

}
