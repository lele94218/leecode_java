package com.terryx.leecode;

import java.util.Stack;

/**
 * @author taoranxue on 10/17/16 2:55 AM.
 */
public class Solution232 {
    public class MyQueue {
        private Stack<Integer> input = new Stack<>();
        private Stack<Integer> output = new Stack<>();

        // Push element x to the back of queue.
        public void push(int x) {
            input.push(x);
        }

        // Removes the element from in front of queue.
        public void pop() {
            if (!input.isEmpty())
                peek();
            output.pop();
        }

        // Get the front element.
        public int peek() {
            if (output.isEmpty()) while (!input.empty()) {
                output.push(input.pop());
            }
            return output.peek();
        }

        // Return whether the queue is empty.
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }
}
