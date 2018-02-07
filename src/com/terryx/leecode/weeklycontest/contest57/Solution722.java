package com.terryx.leecode.weeklycontest.contest57;

import java.util.*;

/**
 * @author taoranxue on 2/5/18 4:54 PM.
 */
public class Solution722 {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        if (source == null || source.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;
        for (String line : source) {
            if (!inBlock) {
                sb = new StringBuilder();
            }

            for (int i = 0; i < line.length(); ++i) {
                if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                    inBlock = true;
                    ++i;
                } else if (inBlock && i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                    inBlock = false;
                    ++i;
                } else if (!inBlock && i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                    break;
                } else if (!inBlock) {
                    sb.append(line.charAt(i));
                }
            }
            if (sb.length() > 0 && !inBlock) {
                res.add(sb.toString());
            }
        }

        return res;
    }

}
