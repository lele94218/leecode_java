package com.terryx.leecode.contest62;

import java.util.*;

/**
 * @author taoranxue on 1/22/18 5:03 PM.
 */
public class Solution745 {
    class WordFilter {

        class TrieNode {
            TrieNode children[];
            int weight;

            TrieNode() {
                children = new TrieNode[27];
            }
        }

        TrieNode root = new TrieNode();

        public WordFilter(String[] words) {
            for (int weight = 0; weight < words.length; ++weight) {
                root.weight = weight;
                String word = words[weight] + '`';
                for (int i = 0; i < word.length(); ++i) {
                    TrieNode cur = root;
                    for (int j = i; j < 2 * word.length() - 1; ++j) {
                        char c = word.charAt(j % (word.length()));
                        //System.out.print(c);
                        if (cur.children[c - '`'] == null) {
                            cur.children[c - '`'] = new TrieNode();
                        }
                        cur = cur.children[c - '`'];
                        cur.weight = weight;
                    }
                }
            }
        }

        public int f(String prefix, String suffix) {
            String word = suffix + "`" + prefix;
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (cur.children[c - '`'] == null) {
                    return -1;
                }
                cur = cur.children[c - '`'];
            }
            return cur.weight;
        }
    }

}
