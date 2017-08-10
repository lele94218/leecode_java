package com.terryx.leecode;

/**
 * @author taoranxue on 8/10/17 3:27 PM.
 */
public class Solution287 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
//         O(n log(n)) Algorithm:

//         int low = 1, high = nums.length - 1, mid = 0;
//         while (low < high) {
//             mid = low + (high - low) / 2;
//             int cnt = 0;

//             for (int i = 0; i < nums.length; ++ i) {
//                 if (nums[i] <= mid) {
//                     cnt ++;
//                 }
//             }

//             if (cnt > mid) {
//                 high = mid;
//             } else {
//                 low = mid + 1;
//             }
//         }

//         return low;

//         O(n) Algorithm:

//         int slow = nums.length, fast = nums.length;
//         while (true) {
//             slow = nums[slow - 1];
//             fast = nums[nums[fast - 1] - 1];
//             if (slow == fast) break;
//         }

//         int find = nums.length;
//         while (true) {
//             slow = nums[slow - 1];
//             find = nums[find - 1];
//             if (find == slow) break;
//         }
//         return slow;

//         Another O(n) Algorithm:
        for (int i = 0; i < nums.length; ++i) {
            int ix = Math.abs(nums[i]);
            if (nums[ix] < 0) {
                return ix;
            }
            nums[ix] = -nums[ix];
        }
        return -1;
    }
}
