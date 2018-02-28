package com.terryx.leecode.weeklycontest.contest54;

import java.util.*;

/**
 * @author taoranxue on 2/9/18 8:05 PM.
 */
public class Solution699 {
    class ST {
        int n, h;
        int tree[], lazy[];

        ST(int n) {
            this.n = n;
            tree = new int[n << 1];
            lazy = new int[n];
            h = 1;
            while ((1 << h) < n) {
                h++;
            }
        }

        void apply(int x, int val) {
            tree[x] = val;
            if (x < n) lazy[x] = val;
        }

        void update(int l, int r, int val) {
            l = l + n;
            r = r + n;
            int l0 = l, r0 = r;
            while (l <= r) {
                if ((l & 1) == 1) {
                    apply(l++, val);
                }
                if ((r & 1) == 0) {
                    apply(r--, val);
                }
                l >>= 1;
                r >>= 1;
            }
            pull(l0, val);
            pull(r0, val);
        }

        int query(int l, int r) {
            l = l + n;
            r = r + n;
            push(l);
            push(r);
            int res = 0;
            while (l <= r) {
                if ((l & 1) == 1) {
                    res = Math.max(res, tree[l++]);
                }
                if ((r & 1) == 0) {
                    res = Math.max(res, tree[r--]);
                }
                l >>= 1;
                r >>= 1;
            }
            return res;
        }

        void push(int x) {
            for (int i = h; i > 0; i--) {
                int y = x >> i;
                if (lazy[y] > 0) {
                    apply(y << 1, lazy[y]);
                    apply((y << 1) + 1, lazy[y]);
                    lazy[y] = 0;
                }
            }
        }

        void pull(int x, int val) {
            while (x > 1) {
                x >>= 1;
                tree[x] = Math.max(tree[x << 1], tree[(x << 1) + 1]);
                tree[x] = Math.max(tree[x], lazy[x]);
            }
        }
    }

    public List<Integer> fallingSquares(int[][] positions) {
        Set<Integer> set = new HashSet<>();
        for (int[] position : positions) {
            int l = position[0], r = l + position[1] - 1;
            set.add(l);
            set.add(r);
        }
        int t = 0;
        Map<Integer, Integer> index = new HashMap<>();
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (Integer pos : list) {
            index.put(pos, t++);
        }
        ST st = new ST(t);
        int max = 0;
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            int l = position[0];
            int r = l + position[1] - 1;
            l = index.get(l);
            r = index.get(r);
            int h = st.query(l, r) + position[1];
            st.update(l, r, h);
            max = Math.max(max, h);
            res.add(max);
        }
        return res;
    }
}
