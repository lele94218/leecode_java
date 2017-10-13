package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/13/17 12:16 AM.
 */
public class OneEditDistance {
    public boolean isOneEditDistance0(String s, String t) {
        if (s == null || t == null) return false;
        for (int i = 0; i < Math.min(s.length(), t.length()); ++i) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() < t.length()) {
                    return (s.substring(i)).equals(t.substring(i + 1));
                } else if (s.length() > t.length()) {
                    return (s.substring(i + 1)).equals(t.substring(i));
                } else {
                    return (s.substring(i + 1)).equals(t.substring(i + 1));
                }
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }

    /**
     * Follow up: no String input, only next() method
     */
    class Stream {
        char s[];
        int idx;

        public char next() {
            if (idx == s.length) {
                return 0;
            }
            return s[idx++];
        }

        Stream(String str) {
            s = str.toCharArray();
            idx = 0;
        }
    }

    public boolean isOneEditDistance1(String s, String t) {
        Stream ss = new Stream(s), ts = new Stream(t);
        return isOneEditDistance1(ss, ts);
    }

    public boolean isOneEditDistance1(Stream s, Stream t) {
        char sBuffer[] = new char[2], tBuffer[] = new char[2];
        sBuffer[0] = s.next();
        tBuffer[0] = t.next();
        sBuffer[1] = s.next();
        tBuffer[1] = t.next();
        while (sBuffer[0] != 0 && tBuffer[0] != 0) {
            if (sBuffer[0] != tBuffer[0]) {
                break;
            }
            sBuffer[0] = sBuffer[1];
            tBuffer[0] = tBuffer[1];
            sBuffer[1] = s.next();
            tBuffer[1] = t.next();
        }
        if (sBuffer[0] == 0 && tBuffer[0] == 0) {
            return false;
        }
        if (sBuffer[0] == 0 && tBuffer[1] == 0 || sBuffer[1] == 0 && tBuffer[0] == 0 || sBuffer[1] == 0 && tBuffer[1] == 0) {
            return true;
        }
        boolean sRemove = true, tRemove = true, modify = true;
        while (sBuffer[0] != 0 && tBuffer[0] != 0) {
            if (sBuffer[0] != tBuffer[1]) {
                tRemove = false;
            }
            if (sBuffer[1] != tBuffer[0]) {
                sRemove = false;
            }
            if (sBuffer[1] != tBuffer[1]) {
                modify = false;
            }
            if (!tRemove && !sRemove && !modify) {
                return false;
            }
            sBuffer[0] = sBuffer[1];
            tBuffer[0] = tBuffer[1];
            sBuffer[1] = s.next();
            tBuffer[1] = t.next();
        }
        if (tRemove && sBuffer[0] == 0 && tBuffer[0] != 0 && tBuffer[1] == 0) return true;
        if (sRemove && tBuffer[0] == 0 && sBuffer[0] != 0 && sBuffer[1] == 0) return true;
        if (modify && tBuffer[0] == 0 && sBuffer[0] == 0) return true;
        return false;
    }
}
