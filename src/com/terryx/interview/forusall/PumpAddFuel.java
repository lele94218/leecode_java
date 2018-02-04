package com.terryx.interview.forusall;

import java.util.*;

/**
 * @author taoranxue on 2/3/18 3:35 PM.
 */
public class PumpAddFuel {
    class Pump {
        int remain;
        int time;
        int label;

        Pump(int label, int remain, int time) {
            this.remain = remain;
            this.time = time;
            this.label = label;
        }
    }

    class sortPump implements Comparator<Pump> {
        @Override
        public int compare(Pump o1, Pump o2) {
            if (o1.time != o2.time) {
                return o1.time - o2.time;
            }
            return o1.label - o2.label;
        }
    }

    public int getMaximum(int[] A, int X, int Y, int Z) {

        PriorityQueue<Pump> queue = new PriorityQueue<>(new sortPump());

        queue.add(new Pump(1, X, 0));
        queue.add(new Pump(2, Y, 0));
        queue.add(new Pump(3, Z, 0));

        int t = 0;
        for (int number : A) {
            List<Pump> temp = new ArrayList<>();

            while (!queue.isEmpty() && queue.peek().remain < number) {
                temp.add(queue.poll());
            }

            if (queue.isEmpty()) {
                return -1;
            }

            Pump cur = queue.poll();
            t = Math.max(t, cur.time);
            cur.remain -= number;
            cur.time = t + number;

            queue.add(cur);
            queue.addAll(temp);

        }

        return t;

    }

    public static void main(String[] args) {
        PumpAddFuel m = new PumpAddFuel();
        System.out.println(m.getMaximum(new int[]{2, 8, 4, 3, 2}, 7, 11, 3));
    }

}
