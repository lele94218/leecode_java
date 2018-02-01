package com.terryx.interview.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/17/17 2:32 PM.
 */
public class TaskWithCoolDown {

    static class Pair {
        int cnt;
        char c;

        Pair(int cnt, char c) {
            this.cnt = cnt;
            this.c = c;
        }
    }

    // Task Cool down 1, 不能改变task的顺序，求一共多少时间处理。

    /**
     * Hash table O(n)
     */
    public String coolDown(String s, int k) {
        if (s == null || s.length() == 0) return "";
        int cnt[] = new int[256];
        Arrays.fill(cnt, -1);
        int idx = 0, time = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < s.length()) {
            if (cnt[s.charAt(idx)] == -1 || time - cnt[s.charAt(idx)] > k) {
                cnt[s.charAt(idx)] = time;
                sb.append(s.charAt(idx++));
            } else {
                sb.append("_");
            }
            time++;
        }
        return sb.toString();
    }


    // Task Cooldown 2, 可以改变task的顺序，求最少多少时间。

    /**
     * O(n) heap with cache
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int cnt[] = new int[26];
        for (int i = 0; i < tasks.length; ++i) {
            cnt[tasks[i] - 'A']++;
        }
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                return b.cnt - a.cnt;
            }
        });
        for (int i = 0; i < cnt.length; ++i)
            if (cnt[i] != 0) {
                queue.offer(new Pair(cnt[i], (char) (i + 'A')));
            }
        int len = tasks.length, res = 0;
        while (!queue.isEmpty()) {
            //int l = Math.min(n + 1, len);
            List<Pair> cache = new ArrayList<>();
            for (int i = 0; i < n + 1; ++i) {
                if (queue.isEmpty() && cache.size() == 0) {
                    break;
                }
                if (!queue.isEmpty()) {
                    Pair tmp = queue.poll();
                    tmp.cnt--;
                    if (tmp.cnt > 0) {
                        cache.add(tmp);
                    }
                }
                res++;
            }
            for (Pair p : cache) {
                queue.offer(p);
            }
        }
        return res;
    }

    // Task 3 没有idle，可以改变顺序，最小长度。不可以返回空

    /**
     * Time O(n) with hash table
     */
    public String rearrangeString(String s, int k) {
        if (s == null) return "";
        int cnt[] = new int[26], nxt[] = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            int idx = -1, max = Integer.MIN_VALUE;
            for (int j = 0; j < cnt.length; ++j) {
                if (cnt[j] > 0 && cnt[j] > max && nxt[j] <= i) {
                    max = cnt[j];
                    idx = j;
                }
            }
            if (idx == -1) {
                return "";
            }
            sb.append((char) ('a' + idx));
            cnt[idx]--;
            nxt[idx] = i + k;
        }
        return sb.toString();
    }

    /**
     * O(n) heap
     */
    public String rearrangeString1(String s, int k) {
        if (s == null) return "";
        if (k == 0) return s;
        int cnt[] = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a']++;
        }
        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair a, Pair b) {
                if (a.cnt != b.cnt) {
                    return b.cnt - a.cnt;
                }
                return a.c - b.c;
            }
        });
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                queue.offer(new Pair(cnt[i], (char) (i + 'a')));
            }
        }
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        while (!queue.isEmpty()) {
            List<Pair> cache = new ArrayList<>();
            int l = Math.min(k, len);
            for (int i = 0; i < l; ++i) {
                if (queue.isEmpty()) {
                    return "";
                }
                Pair tmp = queue.poll();
                sb.append(tmp.c);
                tmp.cnt -= 1;
                if (tmp.cnt > 0) {
                    cache.add(tmp);
                }
                len--;
            }
            for (Pair p : cache) {
                queue.offer(p);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TaskWithCoolDown i = new TaskWithCoolDown();
        System.out.println(i.coolDown("11111223344", 2));
    }
}
