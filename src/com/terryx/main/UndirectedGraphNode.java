package com.terryx.main;

import java.util.*;

/**
 * @author taoranxue on 9/20/17 5:34 PM.
 */
public class UndirectedGraphNode {

    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
