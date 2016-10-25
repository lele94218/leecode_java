package com.terryx.leecode;


/**
 * @author taoranxue on 10/24/16 8:05 PM.
 */
public class Solution208 {
    class TrieNode {
        public boolean isWord;
        public TrieNode[] child;

        // Initialize your data structure here.
        public TrieNode() {
            isWord = false;
            child = new TrieNode[26];
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.child[c - 'a'] == null) {
                    current.child[c - 'a'] = new TrieNode();
                }
                current = current.child[c - 'a'];
            }
            current.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.child[c - 'a'] == null) {
                    return false;
                }
                current = current.child[c - 'a'];
            }
            return current.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (char c : prefix.toCharArray()) {
                if (current.child[c - 'a'] == null) {
                    return false;
                }
                current = current.child[c - 'a'];
            }
            return true;
        }
    }

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
}
