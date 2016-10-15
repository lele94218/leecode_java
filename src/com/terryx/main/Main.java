package com.terryx.main;

import com.terryx.leecode.Solution147;

import java.sql.SQLException;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {

    public static void main(String args[]) throws SQLException {
        Utils utils = new Utils();
        utils.a = 4;
        Solution147 solution147 = new Solution147();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        solution147.insertionSortList(head);
    }

}
