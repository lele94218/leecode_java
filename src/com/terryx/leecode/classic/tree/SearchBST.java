package com.terryx.leecode.classic.tree;

import com.terryx.main.TreeNode;
import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 2/4/18 4:46 PM.
 */
public class SearchBST {
    public int findMinGreaterOrEqual(TreeNode root, int key) {
        if (root == null) {
            return -1;
        }
        if (key < root.val) {
            int k = findMinGreaterOrEqual(root.left, key);
            return k == -1 ? root.val : k;
        } else if (key > root.val) {
            return findMinGreaterOrEqual(root.right, key);
        } else {
            return root.val;
        }
    }

    public int findMaxLessOrEqual(TreeNode root, int key) {
        if (root == null) {
            return -1;
        }
        if (key < root.val) {
            return findMaxLessOrEqual(root.left, key);
        } else if (key > root.val) {
            int k = findMaxLessOrEqual(root.right, key);
            return k == -1 ? root.val : k;
        } else {
            return root.val;
        }
    }


    public static void main(String[] args) {
        TreeNode t = Utils.genTree("[5,2,12,1,3,9,21,null,null,null,null,null,null,19,25]");
        SearchBST m = new SearchBST();
        System.out.println(m.findMinGreaterOrEqual(t, 12));
        System.out.println(m.findMinGreaterOrEqual(t, 13));
        System.out.println(m.findMinGreaterOrEqual(t, 24));
        System.out.println(m.findMinGreaterOrEqual(t, 21));
        System.out.println(m.findMinGreaterOrEqual(t, 20));
        System.out.println(m.findMinGreaterOrEqual(t, 0));

        System.out.println("-------------------------");


        System.out.println(m.findMaxLessOrEqual(t, 12));
        System.out.println(m.findMaxLessOrEqual(t, 13));
        System.out.println(m.findMaxLessOrEqual(t, 24));
        System.out.println(m.findMaxLessOrEqual(t, 21));
        System.out.println(m.findMaxLessOrEqual(t, 20));
        System.out.println(m.findMaxLessOrEqual(t, 0));
    }
}
