package com.terryx.leecode.problem;

/**
 * @author taoranxue on 10/24/16 8:16 PM.
 */
public class Solution211 {
    class WordDictionary {
        class TrieNode {
            TrieNode[] words;
            boolean isWord;
            TrieNode() {
                words = new TrieNode[26];
                isWord = false;
            }
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++ i) {
                char c = word.charAt(i);
                if (cur.words[c - 'a'] == null) {
                    cur.words[c - 'a'] = new TrieNode();
                }
                cur = cur.words[c - 'a'];
                if (i == word.length() - 1) cur.isWord = true;
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            if (word == null) return false;
            TrieNode cur = root;
            return dfs(word, 0, cur);
        }

        private boolean dfs(String word, int idx, TrieNode cur) {
            if (idx >= word.length()) return cur.isWord;
            if (word.charAt(idx) == '.') {
                for (int i = 0; i < 26; ++ i) {
                    if (cur.words[i] != null) {
                        if (dfs(word, idx + 1, cur.words[i])) return true;
                    }
                }
            } else {
                for (int i = idx; i < word.length(); ++ i) {
                    char c = word.charAt(i);
                    if (c != '.') {
                        if (cur.words[c - 'a'] == null) return false;
                        cur = cur.words[c - 'a'];
                        if (i == word.length() - 1 && cur.isWord) return true;
                    } else {
                        return dfs(word, i, cur);
                    }
                }
            }
            return false;
        }
    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
    public class WordDictionary1 {

        private class TireNode {
            boolean isWord;
            TireNode[] child;

            public TireNode() {
                isWord = false;
                child = new TireNode[26];
            }
        }

        private TireNode root = new TireNode();

        // Adds a word into the data structure.
        public void addWord(String word) {
            TireNode current = root;
            for (char c : word.toCharArray()) {
                if (current.child[c - 'a'] == null)
                    current.child[c - 'a'] = new TireNode();
                current = current.child[c - 'a'];
            }
            current.isWord = true;
        }

        // Returns if the word is in the data structure. A word could
        // contain the dot character '.' to represent any one letter.
        public boolean search(String word) {
            return helper(word, 0, root);
        }

        public boolean helper(String word, int index, TireNode current) {
            if (index >= word.length()) return current.isWord;
            char c = word.charAt(index);
            if (c == '.') {
                for (int i = 0; i < current.child.length; ++ i) {
                    if ((current.child[i] != null) && (helper(word, index + 1, current.child[i]))) {
                        return true;
                    }
                }
            } else return (current.child[c - 'a'] != null) && (helper(word, index + 1, current.child[c - 'a']));

            return false;
        }
    }

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
}
