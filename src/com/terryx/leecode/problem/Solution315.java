package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/29/18 4:43 PM.
 */
public class Solution315 {
    // BST
    static class BstNode {
        int value, smaller;
        BstNode left, right;

        BstNode(int value, int smaller) {
            this.value = value;
            this.smaller = smaller;
        }
    }

    private BstNode insert(BstNode root, int value, int index, int res[], int smaller) {
        if (root == null) {
            res[index] = smaller;
            return new BstNode(value, 0);
        }
        if (root.value > value) {
            root.smaller++;
            root.left = insert(root.left, value, index, res, smaller);
        } else {
            root.right = insert(root.right, value, index, res, root.smaller + smaller + ((root.value < value) ? 1 : 0));
        }
        return root;
    }

    public List<Integer> countSmaller0(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        BstNode root = null;
        int helper[] = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; --i) {
            root = insert(root, nums[i], i, helper, 0);
        }
        for (int i = 0; i < nums.length; ++i) {
            res.add(helper[i]);
        }
        return res;
    }

    // Merge sort
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int index[] = new int[nums.length], cnt[] = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            index[i] = i;
        }
        mergeSort(nums, index, cnt, new int[nums.length], 0, nums.length - 1);
        for (int i = 0; i < nums.length; ++i) {
            res.add(cnt[i]);
        }
        return res;
    }

    private void mergeSort(int[] nums, int[] index, int[] cnt, int[] helper, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, index, cnt, helper, start, mid);
        mergeSort(nums, index, cnt, helper, mid + 1, end);
        merge(nums, index, cnt, helper, start, mid, end);
    }

    private void merge(int[] nums, int[] index, int[] cnt, int[] helper, int start, int mid, int end) {
        for (int i = start; i <= end; ++i) {
            helper[i] = index[i];
        }
        int i = start, j = mid + 1, idx = start;
        while (i <= mid && j <= end) {
            if (nums[helper[i]] <= nums[helper[j]]) {
                cnt[helper[i]] += (j - (mid + 1));
                index[idx++] = helper[i++];
            } else {
                index[idx++] = helper[j++];
            }
        }
        while (i <= mid) {
            cnt[helper[i]] += (j - (mid + 1));
            index[idx++] = helper[i++];
        }
    }
}
