package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/15/17 5:58 PM.
 */
public class BrickWall {
    /**
     * General solution.
     */
    public int leastBricks0(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; ++i) {
                sum += list.get(i);
                Integer v = map.get(sum);
                if (v == null) {
                    v = 0;
                }
                map.put(sum, v + 1);
            }
        }
        int res = 0;
        for (Integer v : map.values()) {
            res = Math.max(res, v);
        }
        return wall.size() - res;
    }

    /**
     * If height is k and number of blocks is n. If k << n, use heap.
     */
    static class Block {
        int len, x, y;

        Block(int len, int x, int y) {
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

    public int leastBricks1(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }
        Queue<Block> queue = new PriorityQueue<>(new Comparator<Block>() {
            public int compare(Block a, Block b) {
                return a.len - b.len;
            }
        });
        for (int i = 0; i < wall.size(); ++i) {
            queue.offer(new Block(wall.get(i).get(0), i, 0));
        }
        int res = 0;
        while (queue.size() == wall.size()) {
            int end = queue.peek().len, cnt = 0;
            while (queue.size() == wall.size() && queue.peek().len == end) {
                cnt++;
                Block cur = queue.poll();
                if (cur.y + 1 < wall.get(cur.x).size()) {
                    queue.offer(new Block(cur.len + wall.get(cur.x).get(cur.y + 1), cur.x, cur.y + 1));
                }
            }
            if (queue.size() == wall.size()) {
                res = Math.max(res, cnt);
            }
        }
        return wall.size() - res;
    }
}
