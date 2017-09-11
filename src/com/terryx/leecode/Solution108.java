package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 9/11/17 1:03 PM.
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return BSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode BSTHelper(int[] nums, int left, int right) {
        if (left > right) return null;
        if (left == right) {
            return new TreeNode(nums[right]);
        }
        int mid = (right + left) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        cur.left = BSTHelper(nums, left, mid - 1);
        cur.right = BSTHelper(nums, mid + 1, right);
        return cur;
    }
}
