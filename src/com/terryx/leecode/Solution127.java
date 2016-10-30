package com.terryx.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author taoranxue on 10/29/16 7:43 PM.
 */
public class Solution127 {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> tmpSet = new HashSet<>();
            for (String current : beginSet) {
                for (int i = 0; i < current.length(); ++i) {
                    char tmp[] = current.toCharArray();
                    for (char c = 'a'; c <= 'z'; ++c) {
                        tmp[i] = c;
                        String str = String.valueOf(tmp);

                        if (endSet.contains(str)) {
                            return len + 1;
                        }

                        if (!visited.contains(str) && wordList.contains(str)) {
                            tmpSet.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            beginSet = tmpSet;
            len ++;
        }
        return 0;
    }
}
