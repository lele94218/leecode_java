package com.terryx.leecode.problem;

import java.util.HashSet;
import java.util.Set;

/**
 * @author taoranxue on 10/24/16 10:18 PM.
 */
public class Solution421 {
    public int findMaximumXORByBit(int[] nums) {
        int max = 0;
        int mask = 0;
        for (int i = 31; i >= 0; --i) {
            mask |= (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int a : nums) {
                set.add(a & mask);
            }
            int tmp = (max | (1 << i));
            for (int a : set) {
                if (set.contains(a ^ tmp)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    class TrieNode {
        TrieNode[] child;
        public TrieNode() {
            child = new TrieNode[2];
        }

    }

    private TrieNode root = new TrieNode();

    public int findMaximumXOR(int[] nums) {
        for (int a : nums) {
            TrieNode current = root;
            for (int i = 31; i >= 0; --i) {
                int bit = (a >>> i) & 1;
                if (current.child[bit] == null)
                    current.child[bit] = new TrieNode();
                current = current.child[bit];
            }
        }
        int max = 0;
        for (int a : nums) {
            TrieNode current = root;
            int tmp = 0;
            for (int i = 31; i >= 0; --i) {
                int bit = (a >>> i) & 1;
                if (current.child[bit ^ 1] != null) {
                    current = current.child[bit ^ 1];
                    tmp += (1 << i);
                } else {
                    current = current.child[bit];
                }
            }
            max = Math.max(tmp, max);
        }
        return max;
    }
}
