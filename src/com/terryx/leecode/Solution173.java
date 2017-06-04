package com.terryx.leecode;

import com.terryx.main.TreeNode;

/**
 * @author taoranxue on 6/3/17 9:02 PM.
 */
public class Solution173 {
    public class BSTIterator {
        public TreeNode tr;

        private void insert(TreeNode cur) {
            TreeNode p = tr;
            while (p != null) {
                if (cur.val < p.val) {
                    p = p.left;
                } else {
                    p = p.right;
                }
            }
            p = new TreeNode(cur.val);
        }

        private void dfs(TreeNode cur) {
            insert(cur);
            if (cur.left != null) dfs(cur.left);
            if (cur.right != null) dfs(cur.right);
        }

        public BSTIterator(TreeNode root) {
            dfs(root);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return tr.left != null;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode p = tr;
            while (p.left != null) {
                p = p.left;
            }
            return p.val;
        }
    }
}
