package com.terryx.leecode.weeklycontest.contest74;

import java.util.*;

/**
 * @author taoranxue on 3/3/18 10:05 PM.
 */
public class Solution792 {
    public int numMatchingSubseq(String S, String[] words) {
        List<Integer> lists[] = new List[26];
        for (int i = 0; i < S.length(); ++i) {
            int c = S.charAt(i) - 'a';
            if (lists[c] == null) lists[c] = new ArrayList<>();
            lists[c].add(i);
        }

        int cnt = 0;
        for (String word : words) {
            boolean flag = true;
            int start = -1;
            for (int i = 0; i < word.length(); ++i) {
                int c = word.charAt(i) - 'a';
                if (lists[c] == null) {
                    flag = false;
                    break;
                }
                int low = 0, high = lists[c].size() - 1;
                while (low < high) {
                    int mid = (low + high) / 2;
                    int midVal = lists[c].get(mid);
                    if (start > midVal) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                System.out.println(lists[c]);
                System.out.println(">>" + start + " " + lists[c].get(low));
                if (low >= lists[c].size() || lists[c].get(low) < start) {
                    flag = false;
                    break;
                }
                start = lists[c].get(low) + 1;
            }
            if (flag) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution792 m = new Solution792();
//        System.out.println(m.numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau"}));
        System.out.println(m.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }
}
