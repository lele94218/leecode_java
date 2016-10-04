package com.terryx.leecode;

import com.terryx.main.ListNode;
import com.terryx.main.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author taoranxue on 10/3/16 7:10 PM.
 */
public class Solution109 {
    private List<Integer> list = new ArrayList<>();
    private TreeNode convertBST(int left, int right) {
        if (left > right) return null;
        if (left == right) {
            return new TreeNode(list.get(left));
        }
        int mid = left + (right - left) / 2;
        TreeNode lChild = convertBST(left, mid - 1);
        TreeNode rChild = convertBST(mid + 1, right);
        TreeNode father = new TreeNode(list.get(mid));
        father.right = rChild;
        father.left = lChild;
        return father;
    }
    public TreeNode sortedListToBST(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return convertBST(0, list.size() - 1);
    }
}
