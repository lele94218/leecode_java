package com.terryx.leecode.contest69;

import java.util.*;

/**
 * @author taoranxue on 1/27/18 9:52 PM.
 */
public class Solution775 {
    private void sort(int[] nums, int[] smaller, int[] pos, int from, int to) {
        if (from >= to) return;
        int m = (from + to) / 2;
        sort(nums, smaller, pos, from, m);
        sort(nums, smaller, pos, m + 1, to);
        int[] merged = new int[to - from + 1];
        int i = from, j = m + 1, k = 0, jump = 0;
        while (i <= m || j <= to) {
            if (i > m) {
                jump++;
                merged[k++] = pos[j++];
            } else if (j > to) {
                smaller[pos[i]] += jump;
                merged[k++] = pos[i++];
            } else if (nums[pos[i]] <= nums[pos[j]]) {
                smaller[pos[i]] += jump;
                merged[k++] = pos[i++];
            } else {
                jump++;
                merged[k++] = pos[j++];
            }
        }
        for (int p = 0; p < merged.length; p++) {
            pos[from + p] = merged[p];
        }
    }

    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        int cnt1 = 0, cnt2 = 0;


        int[] smaller = new int[A.length];
        int[] pos = new int[A.length];
        for (int i = 0; i < pos.length; i++) {
            pos[i] = i;
        }
        sort(A, smaller, pos, 0, A.length - 1);

        for (int i = 0; i < smaller.length; ++i) {
            cnt1 += smaller[i];
        }

        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i + 1]) {
                cnt2++;
            }
        }

        return cnt1 == cnt2;
    }

    public static void main(String[] args) {
        Solution775 m = new Solution775();
        System.out.println(m.isIdealPermutation(new int[]{1, 0, 2}));
        System.out.println(m.isIdealPermutation(new int[]{1, 2, 0}));
    }
}
