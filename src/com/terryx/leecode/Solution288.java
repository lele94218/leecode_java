package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 3:57 PM.
 */
public class Solution288 {
    class ValidWordAbbr {
        private Map<String, String> map;

        public ValidWordAbbr(String[] dictionary) {
            map = new HashMap<>();
            for (String word : dictionary) {
                String abbr = toAbbr(word);
                if (!map.containsKey(abbr) || map.containsKey(abbr) && word.equals(map.get(abbr))) {
                    map.put(abbr, word);
                } else {
                    map.put(abbr, "");
                }
            }
        }

        public boolean isUnique(String word) {
            String abbr = toAbbr(word);
            if (!map.containsKey(abbr) || map.containsKey(abbr) && word.equals(map.get(abbr))) {
                return true;
            }
            return false;
        }

        private String toAbbr(String word) {
            if (word == null || word.length() == 0) {
                return "";
            }
            if (word.length() <= 2) {
                return word;
            } else {
                return word.charAt(0) + "" + (word.length() - 2) + "" + word.charAt(word.length() - 1);
            }
        }
    }

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
}
