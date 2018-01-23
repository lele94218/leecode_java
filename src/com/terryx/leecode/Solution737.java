package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/22/18 9:35 PM.
 */
public class Solution737 {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words1.length == 0 || words2 == null || words2.length == 0) {
            return true;
        }
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        int index = 0;
        for (String[] pair : pairs) {
            for (String word : pair) {
                if (!map.containsKey(word)) {
                    map.put(word, index++);
                }
            }
        }

        int parent[] = new int[index], rank[] = new int[index];
        for (int i = 0; i < index; ++i) {
            parent[i] = i;
        }

        for (String[] pair : pairs) {
            String word0 = pair[0], word1 = pair[1];
            unite(map.get(word0), map.get(word1), parent, rank);
        }

        for (int i = 0; i < words1.length; ++i) {
            String word0 = words1[i], word1 = words2[i];
            if (word0.equals(word1)) {
                continue;
            }
            if (!map.containsKey(word0) || !map.containsKey(word1)) {
                return false;
            }
            int x = find(map.get(word0), parent), y = find(map.get(word1), parent);
            if (x != y) {
                return false;
            }
        }
        return true;
    }

    private int find(int x, int parent[]) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    private void unite(int x, int y, int parent[], int rank[]) {
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) {
            return;
        }
        if (rank[x] < rank[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
    }
}
