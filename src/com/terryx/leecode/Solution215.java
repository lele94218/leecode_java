package com.terryx.leecode;

import com.terryx.main.Utils;

/**
 * @author taoranxue on 9/23/16 2:52 AM.
 */
public class Solution215 {
    private int[] a;
    private int ans = -1;
    public void quickSelect(int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(left, right);
//            System.out.println(Utils.debug(left, pivot, right));
            if (k == pivot) {
                ans = a[pivot];
                return;
            }
            if (k > pivot) quickSelect(pivot, right, k);
            else quickSelect(left, pivot - 1, k);
        }
    }
    public int partition(int left, int right) {
        int x = a[right];
        int i = left - 1;
        for (int j = left; j < right; ++ j) {
            if (a[j] >= x) {
                i ++;
                int t = a[j];
                a[j] = a[i];
                a[i] = t;
            }
        }
        i ++;
        int t = a[i];
        a[i] = a[right];
        a[right] = t;
//        for (int xx = left; xx <= right; ++ xx) System.out.print(a[xx] + " ");
//        System.out.println();
        return i;
    }
    public int findKthLargest(int[] nums, int k) {
        if (nums.length <= 1) return nums[0];
        a = nums;
        quickSelect(0, nums.length - 1, k - 1);
        return ans;
    }
}
