package com.terryx.leecode.weeklycontest.contest69;

import java.util.*;

/**
 * @author taoranxue on 1/27/18 10:40 PM.
 */
public class Solution774 {
    public double minmaxGasDist(int[] stations, int K) {
        if (stations == null || stations.length == 0) {
            return 0.0;
        }
        int len[] = new int[stations.length - 1];
        int max = 0;
        for (int i = 1; i < stations.length; ++i) {
            len[i - 1] = stations[i] - stations[i - 1];
            max = Math.max(len[i - 1], max);
        }
        Arrays.sort(len);
        double low = 0.0, high = (double) max;
        for (int i = 0; i < 100; ++i) {
            //System.out.println(low + " " + high);
            double mid = (low + high) / 2.0;
            if (isOk(len, mid, K)) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }

    private boolean isOk(int[] len, double x, int K) {
        int cnt = 0;
        for (int i = len.length - 1; i >= 0; --i) {
            double l = (double) len[i];
//            if (l > x) {
//                if (l - x > x) {
//                    return false;
//                }
//                cnt++;
//            }
            cnt += ((int) Math.ceil(l / x) - 1);
        }
        return cnt <= K;
    }

    public static void main(String[] args) {
        Solution774 m = new Solution774();
        System.out.println(m.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));
        System.out.println(m.minmaxGasDist(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 8));
        System.out.println(m.minmaxGasDist(new int[]{10, 19, 25, 27, 56, 63, 70, 87, 96, 97}, 3));
    }
}
