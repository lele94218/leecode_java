package com.terryx.leecode;

import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 6/5/17 6:21 PM.
 */
public class Solution199 {
    public class TreeNodeWrap {
        public TreeNode tr;
        public TreeNodeWrap next;
        public TreeNodeWrap(TreeNode tr) {
            this.tr = tr;
            next = null;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNodeWrap _root = new TreeNodeWrap(root);
        while (_root != null) {
            TreeNodeWrap dump = new TreeNodeWrap(null);
            TreeNodeWrap head = dump;
            while (_root != null) {
                if (_root.tr.left != null) {
                    dump.next = new TreeNodeWrap(_root.tr.left);
                    dump = dump.next;
                }
                if (_root.tr.right != null) {
                    dump.next = new TreeNodeWrap(_root.tr.right);
                    dump = dump.next;
                }
                _root = _root.next;
            }
            res.add(dump.tr.val);
            _root = head.next;
        }
        return res;
    }
}
