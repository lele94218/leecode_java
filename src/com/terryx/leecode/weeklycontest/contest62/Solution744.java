package com.terryx.leecode.weeklycontest.contest62;

/**
 * @author taoranxue on 1/20/18 6:35 PM.
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) {
            return 0;
        }
        int low = 0, high = letters.length - 1, mid = 0;
        while (low + 1 <= high) {
            mid = (low + high) / 2;
            if (letters[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if (letters[high] <= target) {
            return letters[0];
        }
        return letters[high];
    }

    public static void main(String[] args) {
        Solution744 m = new Solution744();
        System.out.println(m.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(m.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(m.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(m.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(m.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(m.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
    }
}
