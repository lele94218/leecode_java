package com.terryx.main;

import com.terryx.leecode.Solution23;

import java.util.Random;

/**
 * @author xueta on 8/25/2016 8:06 AM.
 */
public class Main {
    public static void main(String args[]) {
        Solution23 solution23 = new Solution23();
        Solution23.ListNode[] listNodes = new Solution23.ListNode[10000];
        Random random = new Random();
        for (int i = 0; i < 10000; ++ i) {
            listNodes[i] = new Solution23.ListNode(random.nextInt()%100);
        }

        Solution23.ListNode listNode = solution23.mergeKLists(new Solution23.ListNode[]{new Solution23.ListNode(1)});
        System.out.println(listNode);
        System.out.println("ok");
//        while (listNode != null) {
//            System.out.print(listNode + " ");
//            listNode = listNode.next;
//        }
//        System.out.println();
    }

}
