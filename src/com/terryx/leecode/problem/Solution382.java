package com.terryx.leecode.problem;

import com.terryx.main.ListNode;

import java.util.Random;

/**
 * @author taoranxue on 10/30/16 4:04 PM.
 */
public class Solution382 {

    public class Solution {
        ListNode head;

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            int res = head.val;
            Random random = new Random();
            ListNode current = head;
            int k = 1;
            while (current != null) {
                int r = random.nextInt(k++);
                if (r == 0) {
                    res = current.val;
                }
                current = current.next;
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

}
