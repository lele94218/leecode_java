package com.terryx.interview.purestorage;

/**
 * 定义buddy system为一棵complete binary tree
 * 一个node可能为0 也可能为1.
 * 它的value为1，当且仅当它所有的child的value均为1.
 *
 * @author taoranxue on 11/2/17 1:29 AM.
 */
public class BuddySystem {
    public static void clearBit(int[][] matrix,  int offset, int length) {
        int level = matrix.length - 1;
        int left = offset, right = offset + length - 1;
        while (level >= 0) {
            for (int i = left; i <= right; ++ i) {
                matrix[level][i] = 0;
            }
            level--;
            left /= 2;
            right /= 2;
        }
    }

    public static void setBit(int[][] matrix,  int offset, int length) {
        int level = matrix.length - 1;
        int left = offset, right = offset + length - 1;
        while (level >= 0) {
            for (int i = left; i <= right; ++ i) {
                matrix[level][i] = 1;
            }
            int leftSibling = left + (left % 2 == 0 ? 1 : -1);
            int rightSibling = right + (right % 2 == 0 ? 1 : -1);
            int nextLeft = left / 2, nextRight = right / 2;
            if (matrix[level][leftSibling] * matrix[level][left] == 0) {
                nextLeft = Math.min(nextLeft + 1, (1 << level) - 1);
            }
            if (matrix[level][rightSibling] * matrix[level][right] == 0) {
                nextRight = Math.max(nextRight - 1, 0);
            }
            level--;
            left = nextLeft;
            right = nextRight;
        }
    }

    public static void main(String[] args) {
        int matrix[][] = new int[4][8];

        for (int i = 0; i < matrix.length; ++ i) {
            for (int j = 0; j < 1 << i; ++ j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        setBit(matrix, 1, 5);


        for (int i = 0; i < matrix.length; ++ i) {
            for (int j = 0; j < 1 << i; ++ j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        clearBit(matrix, 2, 3);


        for (int i = 0; i < matrix.length; ++ i) {
            for (int j = 0; j < 1 << i; ++ j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
