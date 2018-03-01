package com.terryx.leecode.weeklycontest.contest49;

import java.util.*;

/**
 * @author taoranxue on 3/1/18 3:10 PM.
 */
public class Solution676 {
    class MagicDictionary {

        Set<String> set;

        /** Initialize your data structure here. */
        public MagicDictionary() {
            set = new HashSet<>();
        }

        /** Build a dictionary through a list of words */
        public void buildDict(String[] dict) {
            for (String word : dict) {
                set.add(word);
            }
        }

        /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
        public boolean search(String word) {
            char[] str = word.toCharArray();
            for (int i = 0; i < word.length(); ++ i) {
                char c = word.charAt(i);
                for (char cc = 'a'; cc <= 'z'; ++ cc) {
                    if (cc == c) continue;
                    str[i] = cc;
                    if (set.contains(new String(str))) {
                        return true;
                    }
                    str[i] = c;
                }
            }
            return false;
        }
    }
}
