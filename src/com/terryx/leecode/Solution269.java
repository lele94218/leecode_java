package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/24/17 6:14 PM.
 */
public class Solution269 {
    // BFS version
    public String alienOrder(String[] words) {
        boolean adj[][] = new boolean[26][26];
        int deg[] = new int[26];
        Arrays.fill(deg, -1);
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j < words[i].length(); ++j) {
                int k = words[i].charAt(j) - 'a';
                deg[k] = deg[k] < 0 ? 0 : deg[k];
            }
            if (i > 0) {
                String word0 = words[i - 1], word1 = words[i];
                for (int j = 0; j < Math.min(word0.length(), word1.length()); ++j) {
                    char c0 = word0.charAt(j), c1 = word1.charAt(j);
                    if (c0 != c1) {
                        if (!adj[c0 - 'a'][c1 - 'a']) {
                            adj[c0 - 'a'][c1 - 'a'] = true;
                            deg[c1 - 'a']++;
                        }
                        break;
                    }
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < deg.length; ++i) {
            if (deg[i] == 0) {
                queue.offer(i);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.append((char) (cur + 'a'));
            for (int i = 0; i < 26; ++i)
                if (adj[cur][i]) {
                    deg[i]--;
                    if (deg[i] == 0) queue.offer(i);
                }
        }
        for (int i = 0; i < deg.length; ++i) if (deg[i] > 0) return "";
        return res.toString();

    }

    // DFS version
//     public String alienOrder(String[] words) {
//         boolean adj[][] = new boolean[26][26];
//         int vist[] = new int[26];
//         Arrays.fill(vist, -1);
//         for (int i = 0; i < words.length; ++ i) {
//             for (int j = 0; j < words[i].length(); ++ j) {
//                 vist[words[i].charAt(j) - 'a'] = 0;
//             }
//             if (i > 0) {
//                 String word0 = words[i - 1], word1 = words[i];
//                 for (int j = 0; j < Math.min(word0.length(), word1.length()); ++ j) {
//                     char c0 = word0.charAt(j), c1 = word1.charAt(j);
//                     if (c0 != c1) {
//                         adj[c0 - 'a'][c1 - 'a'] = true;
//                         break;
//                     }
//                 }
//             }
//         }
//         StringBuilder res = new StringBuilder();
//         for (int i = 0; i < 26; ++ i) {
//             if (vist[i] == 0) {
//                 if (!dfs(i, adj, vist, res)) return "";
//             }
//         }
//         return res.reverse().toString();
//     }

//     private boolean dfs(int cur, boolean[][] adj, int[] vist, StringBuilder res) {
//         vist[cur] = 1;
//         for (int i = 0; i < 26; ++ i) {
//             if (adj[cur][i]) {
//                 if (vist[i] == 1) return false;
//                 if (vist[i] == 0) {
//                     if (!dfs(i, adj, vist, res)) return false;
//                 }
//             }
//         }
//         vist[cur] = 2;
//         res.append((char)(cur + 'a'));
//         return true;
//     }
}
