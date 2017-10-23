package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 10/23/17 1:38 AM.
 */
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        int index = 0;
        while (index < words.length) {
            StringBuilder sb = new StringBuilder();
            int cnt = words[index].length(), last = index;
            while (last + 1 < words.length && cnt + words[last + 1].length() + 1 <= maxWidth) {
                last++;
                cnt += words[last].length() + 1;
            }
            int remain = maxWidth - cnt;
            sb.append(words[index]);
            if (last - index == 0 || last == words.length - 1 || remain == 0) {
                for (int i = index + 1; i <= last; ++i) {
                    sb.append(" " + words[i]);
                }
                while (remain-- > 0) {
                    sb.append(" ");
                }
            } else {
                int internal = remain / (last - index), r = remain % (last - index);
                for (int i = index + 1; i <= last; ++i) {
                    for (int j = 0; j < internal + (i - index - 1 < r ? 1 : 0); ++j) {
                        sb.append(" ");
                    }
                    sb.append(" " + words[i]);
                }
            }
            res.add(sb.toString());
            index = last + 1;
        }
        return res;
    }
}
