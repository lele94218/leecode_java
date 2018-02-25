package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 2/24/18 9:18 PM.
 */
public class Solution255 {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, top = -1;
        for (int i = 0; i < preorder.length; ++i) {
            int node = preorder[i];
            if (node < low) {
                return false;
            }
            while (top >= 0 && node > preorder[top]) {
                low = preorder[top--];
            }
            preorder[++top] = node;
        }
        return true;
    }
}
