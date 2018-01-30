package com.terryx.leecode.weeklycontest.contest42;


import java.util.List;

/**
 * @author taoranxue on 7/23/17 9:58 AM.
 */
public class Solution648 {
    class TrieNode {
        TrieNode[] child;
        boolean isLeaf;

        public TrieNode() {
            child = new TrieNode[55];
            isLeaf = false;
        }

    }

    public String replaceWords(List<String> dict, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                if (cur.child[word.charAt(i) - 'a'] == null) {
                    cur.child[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.child[word.charAt(i) - 'a'];
                if (i == word.length() - 1) {
                    cur.isLeaf = true;
                }
            }
        }
        String[] tokens = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            TrieNode cur = root;
            StringBuilder newToken = new StringBuilder();

//            cur = cur.child[token.charAt(0) - 'a'];
            boolean found = false;
            System.out.println(token);
            for (int i = 0; i < token.length(); ++i) {
                if (cur.child[token.charAt(i) - 'a'] != null) {
                    cur = cur.child[token.charAt(i) - 'a'];
                    if (cur.isLeaf) {
                        newToken.append(token.charAt(i));
                        newToken.append(" ");
                        sb.append(newToken);
                        found = true;
                        break;
                    } else {
                        newToken.append(token.charAt(i));
                    }
                } else {
                    break;
                }
            }

            if (!found) {
                System.out.println("-->" + token);
                    sb.append(token + " ");
            }

        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
