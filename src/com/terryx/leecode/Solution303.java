package com.terryx.leecode;

/**
 * @author taoranxue on 10/18/16 12:47 AM.
 */
public class Solution303 {
    public class NumArray {
        private int[] sum;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                sum = new int[0];
                return;
            }
            sum = new int[nums.length + 1];
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; ++i) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i == 0) return sum[j];
            return sum[j] - sum[i - 1];
        }
    }


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
}
