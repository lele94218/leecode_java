package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 10/29/16 7:43 PM.
 */
public class Solution127 {
    /**
     * BFS
     */
    public int ladderLength0(String begin, String end, List<String> wordList) {
        if (begin == null || end == null || wordList == null || wordList.size() == 0) {
            return 0;
        }
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> vist = new HashSet<>();
        queue.offer(begin);
        vist.add(begin);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int idx = 0; idx < size; ++idx) {
                if (end.equals(queue.peek())) {
                    return level + 1;
                }
                char str[] = queue.poll().toCharArray();
                for (int i = 0; i < str.length; ++i) {
                    char origin = str[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        str[i] = c;
                        String tmp = new String(str);
                        if (!vist.contains(tmp) && dict.contains(tmp)) {
                            queue.offer(tmp);
                            vist.add(tmp);
                        }
                    }
                    str[i] = origin;
                }
            }
            level++;
        }
        return 0;
    }

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
            len++;
        }
        return 0;
    }
}
