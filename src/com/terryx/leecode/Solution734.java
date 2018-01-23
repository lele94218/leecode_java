package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/22/18 9:14 PM.
 */
public class Solution734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words1.length == 0 || words2 == null || words2.length == 0) {
            return true;
        }
        if (words1.length != words2.length) {
            return false;
        }
        Set<String> dict = new HashSet<>();
        for (String[] pair : pairs) {
            dict.add(pair[0] + "$" + pair[1]);
        }

        for (int i = 0; i < words1.length; ++i) {
            String word1 = words1[i], word2 = words2[i];
            if (!word1.equals(word2) && !dict.contains(word1 + "$" + word2) && !dict.contains(word2 + "$" + word1)) {
                return false;
            }
        }

        return true;
    }
}
