package com.terryx.leecode;

/**
 * @author taoranxue on 8/4/17 4:51 PM.
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int height = matrix.length, width = matrix[0].length;
        int low = 0, high = height * width - 1;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int val = matrix[mid / width][mid % width];
            if (val < target) {
                low = mid + 1;
            } else if (val > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
