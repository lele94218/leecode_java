package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 8/31/17 4:44 PM.
 */
public class Solution9 {
    public boolean isPalindrome(int x) {
        if (x % 10 == 0 && x != 0) return false;

        if (x < 0) return false;
        int num = 0;
        while (x > num) {
            num = num * 10 + x % 10;
            x /= 10;
        }

        return num == x || x == (num / 10);
    }
}
