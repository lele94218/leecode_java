package com.terryx.leecode.weeklycontest.contest74;

import java.util.*;

/**
 * @author taoranxue on 3/3/18 11:34 PM.
 */
public class Solution793 {
    public int preimageSizeFZF(int K) {
        long low = 0, high = Long.MAX_VALUE;
        long left = -1, right = -1;
        while (low <= high) {
            long mid = low + ((high - low) >>> 1);
            long cnt = 0;
            for (int i = 5; mid / i >= 1; i *= 5) {
                cnt += mid / i;
            }
            if (cnt > K) {
                high = mid - 1;
            } else {
                if (cnt == K) right = mid;
                low = mid + 1;
            }
        }


        low = 0;
        high = Long.MAX_VALUE;
        while (low <= high) {
            long mid = low + ((high - low) >>> 1);
            long cnt = 0;
            for (int i = 5; mid / i >= 1; i *= 5) {
                cnt += mid / i;
            }
            if (cnt < K) {
                low = mid + 1;
            } else {
                if (cnt == K) left = mid;
                high = mid - 1;
            }
        }

//        System.out.println(left + " " + right);

        if (left != -1 && right != -1) {
            return (int) (right - left + 1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution793 m = new Solution793();
        System.out.println(m.preimageSizeFZF(0));
        System.out.println(m.preimageSizeFZF(5));
    }

}
