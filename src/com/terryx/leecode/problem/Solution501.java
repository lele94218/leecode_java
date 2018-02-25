package com.terryx.leecode.problem;

import com.terryx.main.TreeNode;

import java.util.*;

/**
 * @author taoranxue on 2/24/18 6:14 PM.
 */
public class Solution501 {

    int[] ans;
    int curVal, curCnt = -1, index = 0, maxCnt = 0;

    public int[] findMode(TreeNode root) {
        helper(root);
        ans = new int[index];
        index = 0;
        curCnt = -1;
        helper(root);
        return ans;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (curCnt == -1) {
            curVal = root.val;
            curCnt = 0;
        }
        if (root.val != curVal) {
            curVal = root.val;
            curCnt = 0;
        }
        curCnt++;
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            index = 1;
        } else if (curCnt == maxCnt) {
            if (ans != null) {
                ans[index] = curVal;
            }
            index++;
        }
        helper(root.right);
    }
}
