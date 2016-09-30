package com.terryx.main;

/**
 * @author taoranxue on 9/30/16 2:13 PM.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "[" + val + "]";
    }
}

