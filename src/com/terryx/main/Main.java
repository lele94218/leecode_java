package com.terryx.main;

import com.terryx.leecode.Solution19;
import com.terryx.leecode.Solution218;

import java.math.BigInteger;
import java.util.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {

    public static int evalRPN(String[] tokens) {

        int returnValue = 0;

        String operators = "+-*^";

        Stack<String> stack = new Stack<String>();

        for (String t : tokens) {
            if (!operators.contains(t)) {
                stack.push(t);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch (index) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf((int)Math.pow(b, a)));
                        break;
                }
            }
        }

        returnValue = Integer.valueOf(stack.pop());

        return returnValue;

    }

    public static void main(String args[]) {
        Solution19 solution19 = new Solution19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head = solution19.removeNthFromEndSmart(head, 1);
        System.out.println("ans: ");
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }

}
