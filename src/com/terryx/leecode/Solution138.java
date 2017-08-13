package com.terryx.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taoranxue on 8/13/17 8:46 PM.
 */
public class Solution138 {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode cpHead = new RandomListNode(head.label);
        RandomListNode cpCur = cpHead;
        RandomListNode cur = head;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (cur != null) {
            // System.out.println("ok");
            if (cur.next != null) {
                if (map.get(cur.next) != null) {
                    cpCur.next = map.get(cur.next);
                } else {
                    cpCur.next = new RandomListNode(cur.next.label);
                    map.put(cur.next, cpCur.next);
                }
            }

            if (cur.random != null) {
                if (map.get(cur.random) != null) {
                    cpCur.random = map.get(cur.random);
                } else {
                    cpCur.random = new RandomListNode(cur.random.label);
                    map.put(cur.random, cpCur.random);
                }
            }

            cur = cur.next;
            cpCur = cpCur.next;

        }

        return cpHead;
    }
}

