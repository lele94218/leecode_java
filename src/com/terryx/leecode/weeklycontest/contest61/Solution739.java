package com.terryx.leecode.weeklycontest.contest61;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 1/23/18 3:32 PM.
 */
public class Solution739 {

    static class Pair {
        int value, index;
        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }

        int res[] = new int[temperatures.length];
        Deque<Pair> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; -- i) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp >= stack.peek().value) {
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek().value > temp) {
                res[i] = stack.peek().index - i;
            } else {
                res[i] = 0;
            }
            stack.push(new Pair(temp, i));
        }

        return res;
    }

    public static void main(String[] args) {
        Solution739 m = new Solution739();
        System.out.println(Utils.debug(m.dailyTemperatures(new int[]{73,74,75,71,69,72,76,73})));
    }
}
