package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/22/18 6:28 PM.
 */
public class Solution399 {

//    static class Pair {
//        String varible;
//        double value;
//
//        Pair(String varible, double value) {
//            this.varible = varible;
//            this.value = value;
//        }
//    }
//
//    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
//        if (equations == null || equations.length == 0 || values == null || values.length == 0 ||
//                queries == null || queries.length == 0) {
//            return new double[0];
//        }
//
//        Map<String, Map<String, Double>> edge = new HashMap<>();
//
//        int len = equations.length;
//        for (int i = 0; i < len; ++i) {
//            String[] equation = equations[i];
//            double value = values[i];
//            String a = equation[0], b = equation[1];
//            if (!edge.containsKey(a)) {
//                edge.put(a, new HashMap<>());
//            }
//            edge.get(a).put(b, value);
//
//            if (!edge.containsKey(b)) {
//                edge.put(b, new HashMap<>());
//            }
//            edge.get(b).put(a, value == 0 ? Double.POSITIVE_INFINITY : 1.0 / value);
//        }
//
//        int index = 0;
//        double[] res = new double[queries.length];
//        for (String[] query : queries) {
//            String a = query[0], b = query[1];
//            double tmp = -1.0;
//            if (edge.containsKey(a)) {
//                Set<String> visited = new HashSet<>();
//                Queue<Pair> queue = new LinkedList<>();
//                queue.offer(new Pair(a, 1.0));
//                visited.add(a);
//                while (!queue.isEmpty()) {
//                    Pair cur = queue.poll();
//                    if (cur.varible.equals(b)) {
//                        tmp = cur.value;
//                        break;
//                    }
//                    if (edge.containsKey(cur.varible)) {
//                        Map<String, Double> adjs = edge.get(cur.varible);
//                        for (String to : adjs.keySet()) {
//                            if (!visited.contains(to)) {
//                                queue.offer(new Pair(to, cur.value * adjs.get(to)));
//                                visited.add(to);
//                            }
//                        }
//                    }
//                }
//            }
//            res[index++] = tmp;
//        }
//        return res;
//    }


    int parent[], rank[];
    Map<String, Integer> map = new HashMap<>();
    Map<String, Double> value = new HashMap<>();

    private int find(int x, int parent[]) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x], parent);
    }

    private void unite(int x, int y, int parent[], int rank[], double ratio) {
        x = find(x, parent);
        y = find(y, parent);
        if (x == y) {
            return;
        }
        for (String key : map.keySet()) {
            if (parent[map.get(key)] == x) {
                value.put(key, value.get(key) * ratio);
            }
        }

        if (rank[x] < rank[y]) {
            parent[x] = parent[y];
        } else {
            parent[y] = x;
            if (rank[x] == rank[y]) {
                rank[x]++;
            }
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || values == null || queries == null) {
            return null;
        }
        int len = queries.length * 2;
        parent = new int[len];
        rank = new int[len];
        for (int i = 0; i < len; ++i) {
            parent[i] = i;
        }
        int index = 0;
        for (int i = 0; i < equations.length; ++i) {
            String[] equation = equations[i];
            String word0 = equation[0], word1 = equation[1];
            if (!map.containsKey(word0) && !map.containsKey(word1)) {
                map.put(word0, index++);
                map.put(word1, index++);
                int x = map.get(word0), y = map.get(word1);
                value.put(word0, values[i]);
                value.put(word1, 1.0);
                parent[x] = y;
            } else if (!map.containsKey(word0)) {
                map.put(word0, index++);
                value.put(word0, value.get(word1) * values[i]);
                int x = map.get(word0), y = map.get(word1);
                parent[x] = y;
            } else if (!map.containsKey(word1)) {
                map.put(word1, index++);
                value.put(word1, value.get(word0) / values[i]);
                int x = map.get(word0), y = map.get(word1);
                parent[y] = x;
            } else {
                int x = map.get(word0), y = map.get(word1);
                double ratio = value.get(word1) * values[i] / value.get(word0);
                unite(x, y, parent, rank, ratio);
            }
        }

        double res[] = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            String[] query = queries[i];
            String word0 = query[0], word1 = query[1];
            if (!map.containsKey(word0) || !map.containsKey(word1) ||
                    find(map.get(word0), parent) != find(map.get(word1), parent)) {
                res[i] = -1;
            } else {
                res[i] = value.get(word0) / value.get(word1);
            }
        }
        return res;
    }
}
