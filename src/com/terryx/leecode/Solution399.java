package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 1/22/18 6:28 PM.
 */
public class Solution399 {

    static class Pair {
        String varible;
        double value;

        Pair(String varible, double value) {
            this.varible = varible;
            this.value = value;
        }
    }

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations == null || equations.length == 0 || values == null || values.length == 0 ||
                queries == null || queries.length == 0) {
            return new double[0];
        }

        Map<String, Map<String, Double>> edge = new HashMap<>();

        int len = equations.length;
        for (int i = 0; i < len; ++i) {
            String[] equation = equations[i];
            double value = values[i];
            String a = equation[0], b = equation[1];
            if (!edge.containsKey(a)) {
                edge.put(a, new HashMap<>());
            }
            edge.get(a).put(b, value);

            if (!edge.containsKey(b)) {
                edge.put(b, new HashMap<>());
            }
            edge.get(b).put(a, value == 0 ? Double.POSITIVE_INFINITY : 1.0 / value);
        }

        int index = 0;
        double[] res = new double[queries.length];
        for (String[] query : queries) {
            String a = query[0], b = query[1];
            double tmp = -1.0;
            if (edge.containsKey(a)) {
                Set<String> visited = new HashSet<>();
                Queue<Pair> queue = new LinkedList<>();
                queue.offer(new Pair(a, 1.0));
                visited.add(a);
                while (!queue.isEmpty()) {
                    Pair cur = queue.poll();
                    if (cur.varible.equals(b)) {
                        tmp = cur.value;
                        break;
                    }
                    if (edge.containsKey(cur.varible)) {
                        Map<String, Double> adjs = edge.get(cur.varible);
                        for (String to : adjs.keySet()) {
                            if (!visited.contains(to)) {
                                queue.offer(new Pair(to, cur.value * adjs.get(to)));
                                visited.add(to);
                            }
                        }
                    }
                }
            }
            res[index++] = tmp;
        }
        return res;
    }
}
