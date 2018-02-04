package com.terryx.leecode.problem;

/**
 * @author taoranxue on 9/23/16 3:22 AM.
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) return true;
            if (matrix[row][col] > target) col --;
            else row ++;
        }
        return false;
    }
}
