package com.terryx.interview.forusall;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 3:37 PM.
 */
public class DominoPyramid {
    boolean res = false;

    public boolean isValid(int[] arr) {

        HashMap<Integer, HashMap<Integer, Integer>> map1 = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> map2 = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i += 2) {
            int a = arr[i];
            int b = arr[i + 1];
            int smaller = a < b ? a : b;
            int larger = a == smaller ? b : a;
            addMap(smaller, larger, map1);
            addMap(larger, smaller, map2);
        }

        Set<String> seen = new HashSet<>();
        Set<List<Integer>> set = new HashSet<>();
        for (Integer first : map1.keySet()) {
            for (Integer second : map1.get(first).keySet()) {
                List<Integer> cur = new ArrayList<>(Arrays.asList(first, second));
                if (!seen.contains(cur.toString())) {
                    seen.add(cur.toString());
                    set.add(cur);
                }
                List<Integer> curNew = new ArrayList<>(Arrays.asList(second, first));
                if (!seen.contains(curNew.toString())) {
                    seen.add(curNew.toString());
                    set.add(curNew);
                }
            }
        }

        for (List<Integer> inter : set) {
            dfs(0, inter, map1, map2);
        }

        return res;

    }

    public void addMap(int a, int b, HashMap<Integer, HashMap<Integer, Integer>> map) {
        map.putIfAbsent(a, new HashMap<>());
        map.get(a).putIfAbsent(b, 0);
        int number = map.get(a).get(b);
        map.get(a).put(b, number + 1);
    }

    public void decMap(
            int a,
            int b,
            HashMap<Integer, HashMap<Integer, Integer>> map1,
            HashMap<Integer, HashMap<Integer, Integer>> map2) {
        int smaller = a < b ? a : b;
        int larger = a == smaller ? b : a;
        dec(smaller, larger, map1);
        dec(larger, smaller, map2);
    }

    public void dec(int a, int b, HashMap<Integer, HashMap<Integer, Integer>> map) {
        int number = map.get(a).get(b);
        map.get(a).put(b, number - 1);
    }

    public void incMap(int a, int b,
                       HashMap<Integer, HashMap<Integer, Integer>> map1,
                       HashMap<Integer, HashMap<Integer, Integer>> map2) {
        int smaller = a < b ? a : b;
        int larger = a == smaller ? b : a;
        inc(smaller, larger, map1);
        inc(larger, smaller, map2);
    }

    public void inc(int a, int b, HashMap<Integer, HashMap<Integer, Integer>> map) {
        int number = map.get(a).get(b);
        map.get(a).put(b, number + 1);
    }

    public boolean isValid(int a, int b, HashMap<Integer, HashMap<Integer, Integer>> map) {
        return map.containsKey(a) && map.get(a).containsKey(b) && map.get(a).get(b) > 0;
    }

    public Set<Integer> getCandidate(int a, HashMap<Integer, HashMap<Integer, Integer>> map) {
        Set<Integer> set = new HashSet<>();
        if (!map.containsKey(a)) {
            return set;
        }
        for (Integer b : map.get(a).keySet()) {
            if (map.get(a).get(b) > 0) {
                set.add(b);
            }
        }
        return set;
    }

    public void dfs(
            int level,
            List<Integer> cur,
            HashMap<Integer, HashMap<Integer, Integer>> map1,
            HashMap<Integer, HashMap<Integer, Integer>> map2) {

        boolean mark = true;
        int flag = cur.size();
        for (int i = 0; i < cur.size() - 1; i += 2) {
            int a = cur.get(i);
            int b = cur.get(i + 1);
            int smaller = a < b ? a : b;
            int larger = a == smaller ? b : a;
            if (!isValid(smaller, larger, map1)) {
                flag = i;
                mark = false;
                break;
            }
            decMap(a, b, map1, map2);
        }

        if (level == 2 && mark) {
            System.out.println(cur.toString());
            res = true;
        }

        if (level < 2 && mark) {

            int start = cur.get(0);
            int end = cur.get(cur.size() - 1);

            Set<Integer> startCandidate = new HashSet<>();
            Set<Integer> endCandidate = new HashSet<>();

            startCandidate.addAll(getCandidate(start, map1));
            startCandidate.addAll(getCandidate(start, map2));

            endCandidate.addAll(getCandidate(end, map1));
            endCandidate.addAll(getCandidate(end, map2));

            for (Integer pre : startCandidate) {
                for (Integer post : endCandidate) {
                    List<Integer> temp = new ArrayList<>(cur);
                    temp.add(0, pre);
                    temp.add(post);
                    dfs(level + 1, temp, map1, map2);
                }
            }

        }

        for (int i = 0; i < flag; i += 2) {
            int a = cur.get(i);
            int b = cur.get(i + 1);
            incMap(a, b, map1, map2);
        }
    }

    public static void main(String[] args) {
        DominoPyramid m = new DominoPyramid();
        System.out.println(m.isValid(new int[]{4, 3, 3, 4, 1, 2, 2, 3, 6, 5, 4, 5}));
    }
}
