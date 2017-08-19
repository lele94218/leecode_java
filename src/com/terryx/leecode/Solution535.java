package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/19/17 12:38 PM.
 */
public class Solution535 {
    public class Codec {
        Map<Integer, String> map = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (longUrl == null || longUrl.length() == 0) return "";
            map.put(longUrl.hashCode(), longUrl);
            return longUrl.hashCode() + "";
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {

            if (shortUrl == null || shortUrl.length() == 0) return "";
            int hash = Integer.parseInt(shortUrl);
            return map.get(hash);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
