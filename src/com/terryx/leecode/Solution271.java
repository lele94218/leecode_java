package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/20/18 2:20 PM.
 */
public class Solution271 {
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            if (strs == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(strs.size()).append("#");
            for (String str : strs) {
                sb.append(str.length()).append("#").append(str);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> ans = new ArrayList<>();
            int cnt = 0, index = 0;
            char c;
            while (index < s.length() && (c = s.charAt(index)) != '#') {
                cnt = cnt * 10 + c - '0';
                index++;
            }

            index++;

            for (int i = 0; i < cnt && index < s.length(); ++i) {
                int len = 0;
                while (index < s.length() && (c = s.charAt(index)) != '#') {
                    len = len * 10 + c - '0';
                    index++;
                }
                ans.add(s.substring(index + 1, index + len + 1));
                index = index + len + 1;
            }
            return ans;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
}
