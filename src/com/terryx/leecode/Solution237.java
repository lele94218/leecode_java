package com.terryx.leecode;

import com.terryx.gwu.algorithm.Point2D;
import com.terryx.main.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author taoranxue on 9/30/16 9:16 PM.
 */


public class Solution237 {
    public class Line implements Comparable<Line> {
        Point2D p1;
        Point2D p2;
        public Line(Point2D p1, Point2D p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        @Override
        public int compareTo(Line other) {
            return (int)(this.p1.x() - other.p1.x());
        }
    }


    public void fun() {
        List<Line> lineList = new ArrayList<>();
        Collections.sort(lineList);
    }

    public void deleteNode(ListNode node) {
        if (node.next == null)
            return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
