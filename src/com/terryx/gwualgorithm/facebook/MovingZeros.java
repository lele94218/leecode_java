package com.terryx.gwualgorithm.facebook;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 10/11/17 8:10 PM.
 */
public class MovingZeros {
    // Keep order version

    /**
     * One pass moving zero to right keep order. Space: O(1) Time: O(n)
     * Number of assignment: if no-zero is k, then 3k
     */
    public void moveZeroes0(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                swap(nums, i, j++);
            }
        }
    }

    /**
     * One pass moving zero to left keep order. Space: O(1) Time: O(n)
     * Number of assignment: if no-zero is k, then 3k
     */
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int j = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] != 0) {
                swap(nums, i, j--);
            }
        }
    }

    /**
     * Two pass moving zero to right keep order. Space: O(1) Time: O(n)
     * Number of assignment: if no-zero is k, then k + (n - k) = n
     */
    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int cntZero = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 0) {
                cntZero++;
            } else {
                if (cntZero != 0) {
                    nums[i - cntZero] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }

    /**
     * Two pass moving zero to left keep order. Space: O(1) Time: O(n))
     * Number of assignment: if no-zero is k, then k + (n - k) = n
     */
    public void moveZeroes3(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int cntZero = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (nums[i] == 0) {
                cntZero++;
            } else {
                nums[i + cntZero] = nums[i];
                if (cntZero != 0) {
                    nums[i] = 0;
                }
            }
        }
    }

    // Don't keep order

    /**
     * One pass moving zero to left don't need to keep order. Space: O(1) Time O(n)
     * Number of assignment: if no-zero and not on right position is k, then k
     */
    public void moveZeroes4(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] != 0) {
                i++;
            } else if (nums[j] == 0) {
                j--;
            } else {
                nums[i++] = nums[j];
                nums[j--] = 0;
            }
        }
    }

    /**
     * One pass moving zero to right don't need to keep order. Space: O(1) Time O(n)
     * Number of assignment: if no-zero and not on right position is k, then k
     */
    public void moveZeroes5(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] == 0) {
                i++;
            } else if (nums[j] != 0) {
                j--;
            } else {
                nums[j--] = nums[i];
                nums[i++] = 0;
            }
        }
    }



    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        MovingZeros m = new MovingZeros();
        int nums[];
        nums = new int[]{1, 2, 3, 4, 0, 0, 0, 0};
        m.moveZeroes5(nums);
        System.out.println(Utils.debug(nums));


        nums = new int[]{1, 0, 3, 4, 0, 0, 9, 9};
        m.moveZeroes5(nums);
        System.out.println(Utils.debug(nums));


        nums = new int[]{1, 2, 3, 4, 4, 2, 1, 1};
        m.moveZeroes5(nums);
        System.out.println(Utils.debug(nums));

        nums = new int[]{1};
        m.moveZeroes5(nums);
        System.out.println(Utils.debug(nums));


        nums = new int[]{0};
        m.moveZeroes5(nums);
        System.out.println(Utils.debug(nums));
    }
}
