package com.terryx.leecode;

/**
 * @author taoranxue on 8/12/17 8:41 PM.
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0 || s2.length() < s1.length()) {
            return false;
        }
        int map1[] = new int[26];
        int map2[] = new int[26];

        for (int i = 0; i < s1.length(); ++i) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

//         for (int i = 0; i <= s2.length() - s1.length(); ++ i) {
//             boolean match = true;
//             for (int j = 0; j < 26; ++ j) {
//                 if (map1[j] != map2[j]) {
//                     match = false;
//                     break;
//                 }
//             }

//             if (match) {
//                 return true;
//             }

//             if (i + s1.length() < s2.length()) {
//                 map2[s2.charAt(i) - 'a']--;
//                 map2[s2.charAt(i + s1.length()) - 'a']++;
//             }
//         }
//         return false;

//         Optimized Algorithm:

        int cnt = 0;
        for (int i = 0; i < map1.length; ++i) {
            if (map1[i] == map2[i]) cnt++;
        }

        for (int i = 0; i <= s2.length() - s1.length(); ++i) {
            if (cnt == map1.length) return true;
            if (i + s1.length() < s2.length()) {
                int left = s2.charAt(i) - 'a', right = s2.charAt(i + s1.length()) - 'a';

                // System.out.println(left + " " + right);
                map2[left]--;
                if (map2[left] == map1[left]) cnt++;
                else if (map2[left] + 1 == map1[left]) cnt--;

                map2[right]++;
                if (map2[right] == map1[right]) cnt++;
                else if (map2[right] - 1 == map1[right]) cnt--;

            }
        }
        return false;

    }
}
