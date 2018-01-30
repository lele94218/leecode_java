package com.terryx.leecode.weeklycontest.contest60;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 1/25/18 4:46 PM.
 */
public class Solution735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null) {
            return new int[0];
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int ast : asteroids) {
            boolean exist = true;
            if (ast < 0) {
                while (!stack.isEmpty() && stack.peek() >= 0) {
                    if (Math.abs(stack.peek()) >= Math.abs(ast)) {
                        exist = false;
                        if (Math.abs(stack.peek()) == Math.abs(ast)) {
                            stack.pop();
                        }
                        break;
                    }
                    stack.pop();
                }
            }
            if (exist) {
                stack.push(ast);
            }
        }
        int[] res = new int[stack.size()];
        int index = stack.size();
        for (Integer e : stack) {
            res[--index] = e;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution735 m = new Solution735();
        System.out.println(Utils.debug(m.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Utils.debug(m.asteroidCollision(new int[]{8, -8})));
        System.out.println(Utils.debug(m.asteroidCollision(new int[]{10, 2, -5})));
        System.out.println(Utils.debug(m.asteroidCollision(new int[]{-2, -1, 1, 2})));
        System.out.println(Utils.debug(m.asteroidCollision(new int[]{-2, 1, 1, -1})));
    }
}
