package com.terryx.leecode.contest59;

import java.util.*;

/**
 * @author taoranxue on 1/29/18 5:53 PM.
 */
public class Solution728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; ++i) {
            if (isSelfDivide(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isSelfDivide(int num) {
        int a = num;
        while (a > 0) {
            int r = a % 10;
            if (r == 0 || num % r != 0) {
                return false;
            }
            a /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution728 m = new Solution728();
        System.out.println(m.selfDividingNumbers(1, 22));
    }
}
