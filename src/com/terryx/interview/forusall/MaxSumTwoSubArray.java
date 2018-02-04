package com.terryx.interview.forusall;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 2:51 PM.
 */
public class MaxSumTwoSubArray {
    public int solve(int[] array, int k, int l) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int n = array.length;
        int left1[] = new int[n], right1[] = new int[n], left2[] = new int[n], right2[] = new int[n];
        int i = 0, sum = 0;
        for (; i < k; ++ i) {
            sum += array[i];
            if (i < k - 1) {
                left1[i] = 0;
            } else {
                left1[i] = sum;
            }
        }

        for (; i < n; ++ i) {
            sum -= array[i - k];
            sum += array[i];
            left1[i] = Math.max(left1[i - 1], sum);
        }

        i = n - 1;
        sum = 0;
        for (; i >= n - k; -- i) {
            sum += array[i];
            if (i >= n - k + 1) {
                right1[i] = 0;
            } else {
                right1[i] = sum;
            }
        }

        for (; i >= 0; -- i) {
            sum -= array[i + k];
            sum += array[i];
            right1[i] = Math.max(right1[i + 1], sum);
        }

        //
        i = 0;
        sum = 0;
        for (; i < l; ++ i) {
            sum += array[i];
            if (i < l - 1) {
                left2[i] = 0;
            } else {
                left2[i] = sum;
            }
        }

        for (; i < n; ++ i) {
            sum -= array[i - l];
            sum += array[i];
            left2[i] = Math.max(left2[i - 1], sum);
        }

        i = n - 1;
        sum = 0;
        for (; i >= n - l; -- i) {
            sum += array[i];
            if (i >= n - l + 1) {
                right2[i] = 0;
            } else {
                right2[i] = sum;
            }
        }

        for (; i >= 0; -- i) {
            sum -= array[i + l];
            sum += array[i];
            right2[i] = Math.max(right2[i + 1], sum);
        }
        int res = 0;
        for (i = 0; i < n - 1; ++ i) {
            res = Math.max(res, left1[i] + right2[i + 1]);
            res = Math.max(res, left2[i] + right1[i + 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSumTwoSubArray m = new MaxSumTwoSubArray();
        System.out.println(m.solve(new int[]{6,1,4,6,3,2,7,4}, 3, 2));
    }
}
