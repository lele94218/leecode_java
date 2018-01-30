package com.terryx.leecode.weeklycontest.contest63;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 7:49 PM.
 */
public class Solution748 {
    static class Pair {
        String word;
        int index;

        Pair(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        Pair pairs[] = new Pair[words.length];
        int index = 0;
        for (int i = 0; i < words.length; ++i) {
            pairs[i] = new Pair(words[i], i);
        }

        Arrays.sort(pairs, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (a.word.length() == b.word.length()) {
                    return a.index - b.index;
                }
                return a.word.length() - b.word.length();
            }
        });

        int map[] = new int[26], cnt = 0;
        for (int i = 0; i < licensePlate.length(); ++i) {
            char c = licensePlate.charAt(i);
            if (Character.isAlphabetic(c)) {
                cnt++;
                map[Character.toLowerCase(c) - 'a']++;
            }
        }
        int tempMap[] = new int[26];
        for (Pair pair : pairs) {
            String word = pair.word;
            Arrays.fill(tempMap, 0);
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                tempMap[c - 'a']++;
            }
            boolean flag = true;
            for (int i = 0; i < 26; ++i) {
                if (tempMap[i] < map[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return word;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution748 m = new Solution748();
        System.out.println(m.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(m.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
