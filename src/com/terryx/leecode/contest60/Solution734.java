package com.terryx.leecode.contest60;

import java.util.*;

/**
 * @author taoranxue on 1/25/18 4:41 PM.
 */
public class Solution734 {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null || pairs == null) {
            return true;
        }

        if (words1.length != words2.length) {
            return false;
        }

        Set<String> dict = new HashSet<>();

        for (String[] pair : pairs) {
            dict.add(pair[0] + "$" + pair[1]);
            dict.add(pair[1] + "$" + pair[0]);
        }

        for (int i = 0; i < words1.length; ++ i) {
            if (!words1[i].equals(words2[i]) || !dict.contains(words1[i] + "$" + words2[i])) {
                return false;
            }
        }
        return true;
    }
}
