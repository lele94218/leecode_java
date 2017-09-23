package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/21/17 2:48 PM.
 */
public class Solution146 {
    class LRUCache {
        class Node {
            Node next, prev;
            int key, value;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int size = 0, cnt = 0;
        Map<Integer, Node> cache;
        Node head, tail;

        public LRUCache(int capacity) {
            size = capacity;
            cache = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        private void addToHead(Node node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
        }

        private void deleteNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                deleteNode(node);
                addToHead(node);
                return node.value;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                deleteNode(node);
                addToHead(node);
            } else if (cnt < size) {
                Node node = new Node(key, value);
                cache.put(key, node);
                addToHead(node);
                cnt++;
            } else {
                Node victim = tail.prev;
                if (victim == head) System.out.println("error!");
                cache.remove(victim.key);
                victim.key = key;
                victim.value = value;
                cache.put(key, victim);
                deleteNode(victim);
                addToHead(victim);
            }
        }
    }
}
