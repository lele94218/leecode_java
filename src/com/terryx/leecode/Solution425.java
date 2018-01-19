package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 6:05 PM.
 */
public class Solution425 {
    static class Trie {
        static class TrieNode {
            TrieNode child[];
            List<String> prefix;

            TrieNode() {
                child = new TrieNode[26];
                prefix = new ArrayList<>();
            }
        }

        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (cur.child[c - 'a'] == null) {
                    cur.child[c - 'a'] = new TrieNode();
                }
                cur.prefix.add(word);
                cur = cur.child[c - 'a'];
            }
        }

        List<String> findByPrefix(String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); ++i) {
                char c = prefix.charAt(i);
                if (cur.child[c - 'a'] != null) {
                    cur = cur.child[c - 'a'];
                } else {
                    return null;
                }
            }
            return cur.prefix;
        }
    }

    private Trie trie;

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        List<String> path = new ArrayList<>();
        for (String word : words) {
            path.add(word);
            dfs(word.length(), path, res);
            path.remove(path.size() - 1);
        }
        return res;
    }

    private void dfs(int len, List<String> path, List<List<String>> res) {
        if (path.size() == len) {
            res.add(new ArrayList<String>(path));
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String word : path) {
            sb.append(word.charAt(path.size()));
        }

        String prefix = sb.toString();
        List<String> words = trie.findByPrefix(prefix);

        //System.out.println(prefix + " " + words);

        if (words == null) {
            return;
        }

        for (String word : words) {
            path.add(word);
            dfs(len, path, res);
            path.remove(path.size() - 1);
        }
    }
}
