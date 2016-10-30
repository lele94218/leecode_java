package com.terryx.leecode;

import java.util.Random;

/**
 * @author taoranxue on 10/30/16 4:10 PM.
 */
public class Solution398 {
    public class Solution {
        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        public int pick(int target) {
            Random random = new Random();
            int res = -1;
            int k = 0;
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] == target) {
                    k++;
                    if (res == -1) {
                        res = i;
                    } else {
                        if (random.nextInt(k) == 0) {
                            res = i;
                        }
                    }
                }
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
