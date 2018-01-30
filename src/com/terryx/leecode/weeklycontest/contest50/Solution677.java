package com.terryx.leecode.weeklycontest.contest50;

import java.util.*;

/**
 * @author taoranxue on 9/16/17 9:50 PM.
 */
public class Solution677 {
    static public class MapSum {
        class TrieNode {
            TrieNode[] child;
            boolean isLeaf;
            int sum;

            public TrieNode() {
                child = new TrieNode[256];
                isLeaf = false;
                sum = 0;
            }

        }

        TrieNode root;
        Map<String, Integer> map;

        /** Initialize your data structure here. */
        public MapSum() {
            root = new TrieNode();
            map = new HashMap<>();
        }

        public void insert(String key, int val) {
            TrieNode cur = root;
            if (map.containsKey(key)) {
                val = val - map.get(key);
            } else {
                map.put(key, val);
            }
            root.sum += val;
            for (int i = 0; i < key.length(); ++ i) {
                if (cur.child[key.charAt(i)] == null) {
                    cur.child[key.charAt(i)] = new TrieNode();
                }
                if (i == key.length() - 1) {
                    cur.child[key.charAt(i)].isLeaf = true;
                }
                cur.child[key.charAt(i)].sum += val;
                cur = cur.child[key.charAt(i)];
            }
        }

        public int sum(String prefix) {
            if (prefix == null) return 0;
            TrieNode cur = root;
            if (prefix.length() == 0) return cur.sum;
            for (int i = 0; i < prefix.length(); ++ i) {
                if (cur.child[prefix.charAt(i)] != null) {
                    if (i == prefix.length() - 1) {
                        return cur.child[prefix.charAt(i)].sum;
                    }
                    cur = cur.child[prefix.charAt(i)];
                }
                else break;
            }
            return 0;
        }
    }

    public static void main(String args[]) throws InterruptedException {
        MapSum mapSum = new MapSum();
        mapSum.insert("aa", 3);
        mapSum.insert("aaa", 3);
        System.out.println(mapSum.sum("a"));
        mapSum.insert("aa", 2);
        System.out.println(mapSum.sum("a"));
    }
}
