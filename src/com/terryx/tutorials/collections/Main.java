package com.terryx.tutorials.collections;

import java.util.*;

/**
 * @author taoranxue on 10/4/16 12:03 AM.
 */
public class Main {
    public static void main(String args[]) {
        //
        HashMap<String, String> hashMap = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        PriorityQueue<Integer> queue;
        Stack<Integer> stack = new Stack<>();
        Deque<Integer> deque;
        Collections collections;
        hashMap.put("a", "A");
        hashMap.put("a", "B");
        hashMap.put("b", "B");
        Collection<String> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet;
        hashSet.add("apple");
        Object[] s = hashSet.toArray();
        System.out.println(s[0]);
    }
}
