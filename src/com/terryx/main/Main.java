package com.terryx.main;

import com.terryx.leecode.*;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public static void main(String args[]) {
        Solution61 solution61 = new Solution61();
        ListNode head = new ListNode(1);
//        head.next = new ListNode(4);
//        head.next.next = new ListNode(3);

        ListNode head1 = new ListNode(5);
//        head1.next = new ListNode(6);
//        head1.next.next = new ListNode(4);
        head = solution61.rotateRight(null, 1);
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }

    }

}
