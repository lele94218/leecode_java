package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/27/18 5:00 PM.
 */
public class Solution307 {
    // Segment Tree
    class NumArray {
        int[] tree;
        int n;

        public NumArray(int[] nums) {
            n = nums.length;
            tree = new int[n << 1];
            int p = n;
            for (int i = 0; i < n; ++i) {
                tree[p++] = nums[i];
            }
            for (int i = n - 1; i > 0; --i) {
                tree[i] = tree[(i << 1) + 1] + tree[i << 1];
            }
        }

        public void update(int i, int val) {
            int pos = i + n;
            tree[pos] = val;
            while (pos > 0) {
                int pa = pos >> 1;
                tree[pa] = tree[(pa << 1) + 1] + tree[pa << 1];
                pos = pa;
            }
        }

        public int sumRange(int i, int j) {
            int left = i + n, right = j + n, sum = 0;
            while (left <= right) {
                if ((left & 1) == 1) {
                    sum += tree[left];
                    left++;
                }
                if ((right & 1) == 0) {
                    sum += tree[right];
                    right--;
                }
                left >>= 1;
                right >>= 1;
            }
            return sum;
        }
    }

    // Binary Index Tree
    class NumArray0 {
        int n;
        int tree[], nums[];

        public NumArray0(int[] nums) {
            this.nums = nums;
            n = nums.length;
            tree = new int[n + 1];
            for (int i = 0; i < n; ++i) {
                add(i + 1, nums[i]);
            }
        }

        private void add(int i, int x) {
            while (i <= n) {
                tree[i] += x;
                i += (i & -i);
            }
        }

        private int sum(int i) {
            int s = 0;
            while (i > 0) {
                s += tree[i];
                i -= (i & -i);
            }
            return s;
        }

        public void update(int i, int val) {
            int diff = val - nums[i];
            nums[i] = val;
            add(i + 1, diff);
        }

        public int sumRange(int i, int j) {
            int l = sum(i);
            int r = sum(j + 1);
            return r - l;
        }
    }
}
