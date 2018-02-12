package com.terryx.leecode.weeklycontest.contest71;

import java.util.*;

/**
 * @author taoranxue on 2/10/18 9:46 PM.
 */
public class Solution781 {
    public int numRabbits(int[] answers) {
        // 0 0 1 1 1
        // 0 0 0 0 0 0 0 0 0 0 0
        // [1, 1, 1] = 0 0 1 1
        // [1, 1, 2] = 0 0 1 1 1
        // [1, 1, 3] = 0 0
        // [2, 3] = 0 0 0 1 1 1 1
        if (answers == null || answers.length == 0) {
            return 0;
        }
        Arrays.sort(answers);
        int i = 0;
        int res = 0;
        while (answers[i] == 0) {
            res++;
            i++;
        }
//        System.out.println(res);
        int pre = answers[i++], cnt = pre + 1, len = 1;
        for (; i < answers.length; ++i) {
            if (answers[i] != pre || len >= cnt) {
                res += cnt;
                pre = answers[i];
                cnt = pre + 1;
                len = 1;
            } else {
                len++;
            }
//            System.out.println(answers[i] + ": " + pre + " " + cnt + " " + len + " = " + res);
        }
        res += cnt;
        return res;
    }

    public static void main(String[] args) {
        Solution781 m = new Solution781();
        System.out.println(m.numRabbits(new int[]{1, 1, 2}));
        System.out.println(m.numRabbits(new int[]{10, 10, 10}));
        System.out.println(m.numRabbits(new int[]{2, 3}));
        System.out.println(m.numRabbits(new int[]{1, 0, 1, 0, 0}));
        System.out.println(m.numRabbits(new int[]{1, 1, 1}));
        System.out.println(m.numRabbits(new int[]{0, 0, 1, 1, 1}));
        System.out.println(m.numRabbits(new int[]{2,1,2,2,2,2,2,2,1,1}));
    }
}
