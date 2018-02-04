package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author taoranxue on 1/18/18 3:10 PM.
 */
public class Solution482 {
    class Solution {
        public String licenseKeyFormatting(String S, int K) {
            if (S == null || S.length() == 0) {
                return S;
            }
            char[] str = S.toCharArray();
            int cnt = 0;
            for (int i = 0; i < str.length; ++i) {
                char c = str[i];
                if (Character.isLetterOrDigit(c)) {
                    cnt++;
                    if (Character.isLowerCase(c)) {
                        str[i] = Character.toUpperCase(c);
                    }
                }
            }

            int remain = cnt % K, index = 0;
            StringBuilder sb = new StringBuilder();
            if (remain != 0) {
                for (; index < str.length && remain > 0; ++index) {
                    char c = str[index];
                    if (Character.isLetterOrDigit(c)) {
                        sb.append(str[index]);
                        remain--;
                    }
                }
                sb.append("-");
            }

            cnt = 0;
            for (; index < str.length; ++index) {
                char c = str[index];
                if (Character.isLetterOrDigit(c)) {
                    sb.append(str[index]);
                    cnt++;
                }

                if (cnt > 0 && cnt % K == 0) {
                    sb.append("-");
                    cnt = 0;
                }
            }
            return sb.toString().substring(0, Math.max(sb.length() - 1, 0));
        }
    }
}
