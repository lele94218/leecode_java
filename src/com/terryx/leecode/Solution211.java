package com.terryx.leecode;

/**
 * @author taoranxue on 10/24/16 8:16 PM.
 */
public class Solution211 {
    public class WordDictionary {

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
