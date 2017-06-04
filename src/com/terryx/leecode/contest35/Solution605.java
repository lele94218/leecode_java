package com.terryx.leecode.contest35;

/**
 * @author taoranxue on 6/3/17 9:31 PM.
 */
public class Solution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt1 = 0;
        int cnt0 = 0;
        int res = 0;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 1) {
                if (cnt1 == 0)
                    res += (int) (cnt0 / 2);
                else
                    res += (int) ((cnt0 - 1) / 2);
                cnt0 = 0;
                ++cnt1;
            }
            if (flowerbed[i] == 0) ++cnt0;
        }

        if (cnt0 > 0) {
                res += (int) (cnt0 / 2);
        }

        if (cnt1 == 0) {
            if (n <= (int) ((flowerbed.length - 1) / 2) + 1) return true;
            return false;
        }

        if (n <= res) return true;
        return false;

    }
}
