package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 8/19/17 10:01 AM.
 */
public class Solution299 {
    public String getHint(String secret, String guess) {
        if (secret == null || secret.length() == 0 || guess == null || guess.length() == 0) return "0A0B";
        int bull = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); ++i) {
            Integer v = map.get(secret.charAt(i));
            Character c = secret.charAt(i);
            if (v != null) {
                map.put(c, v + 1);
            } else {
                map.put(c, 1);
            }
            if (c == guess.charAt(i)) bull++;
        }

        int cow = 0;

        for (int i = 0; i < secret.length(); ++i) {
            Character c = guess.charAt(i);
            Integer v = map.get(c);
            if (v != null && v > 0) {
                cow++;
                map.put(c, v - 1);
            }
        }
        return (bull + "A" + (cow - bull) + "B");
    }

}
