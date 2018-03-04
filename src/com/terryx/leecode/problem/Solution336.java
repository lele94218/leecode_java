package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 3/3/18 4:38 PM.
 */
public class Solution336 {
    class TrieNode {
        TrieNode children[];
        int isWord;
        List<Integer> index;

        TrieNode() {
            isWord = -1;
            children = new TrieNode[26];
            index = new ArrayList<>();
        }
    }

    TrieNode root = new TrieNode();

    private void addWord(String word, int index) {
        TrieNode cur = root;
        cur.index.add(index);
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) cur.children[c] = new TrieNode();
            cur = cur.children[c];
            cur.index.add(index);
        }
        cur.isWord = index;
    }

    private List<Integer> findWords(String prefix) {
        TrieNode cur = root;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < prefix.length(); ++i) {
            if (cur.isWord >= 0) res.add(cur.isWord);
            int c = prefix.charAt(i) - 'a';
            if (cur.children[c] == null) return res;
            cur = cur.children[c];
        }
        res.addAll(cur.index);
        return res;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            String rw = (new StringBuilder(word)).reverse().toString();
            addWord(rw, i);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            List<Integer> list = findWords(word);
            if (list != null) for (Integer index : list) {
                String palind = word + words[index];
                if (index != i && palind.equals((new StringBuilder(palind)).reverse().toString())) {
                    ans.add(Arrays.asList(i, index));
                }
            }

        }
        return ans;
    }
}
