package com.terryx.leecode.weeklycontest.contest36;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author taoranxue on 6/10/17 9:45 PM.
 */
public class Solution604 {
    public class StringIterator {
        Queue<Character> queue = new LinkedList<>();
        Queue<Long> longQueue = new LinkedList<>();
        long hasFlag = 0;
        char prevChar = '!';

        public StringIterator(String compressedString) {
            char prevChar = '!';
            for (int i = 0; i < compressedString.length(); ++i) {
                char c = compressedString.charAt(i);
                if (Character.isDigit(c)) {
                    long t = 0;
                    while (i < compressedString.length() && Character.isDigit(compressedString.charAt(i))) {
                        t = t * 10 + compressedString.charAt(i) - '0';
                        ++i;
                    }
                    t -= 1;
                    if (t > 0) {
                        System.out.println(t);
                        longQueue.offer(t);
                        queue.offer('!');
                    }
                    i--;

                } else {
                    queue.offer(c);
                    prevChar = c;
                }
            }
        }

        public char next() {
            if (hasFlag > 0) {
                hasFlag--;
                return prevChar;
            }
            if (hasNext()) {
                char c = queue.poll();
                if (c == '!') {
                    //  System.out.println("@");
                    hasFlag = longQueue.poll();
                    hasFlag--;
                    return prevChar;
                }
                prevChar = c;
                return c;
            }
            return ' ';
        }

        public boolean hasNext() {
            //  System.out.println(hasFlag);
            return !queue.isEmpty() || hasFlag > 0;
        }
    }

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
