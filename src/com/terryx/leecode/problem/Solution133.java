package com.terryx.leecode.problem;

import com.terryx.main.UndirectedGraphNode;

import java.util.*;

/**
 * @author taoranxue on 9/20/17 5:34 PM.
 */
public class Solution133 {
    // BFS version
    // public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    //     if (node == null) return null;
    //     UndirectedGraphNode g = new UndirectedGraphNode(node.label);
    //     Set<Integer> vist = new HashSet<>();
    //     Map<Integer, UndirectedGraphNode> nodes = new HashMap<>();
    //     nodes.put(g.label, g);
    //     Queue<UndirectedGraphNode> queue0 = new LinkedList<>(), queue1 = new LinkedList<>();
    //     queue0.offer(node);
    //     queue1.offer(g);
    //     while (!queue0.isEmpty()) {
    //         UndirectedGraphNode tmp0 = queue0.poll(), tmp1 = queue1.poll();
    //         if (vist.contains(tmp0.label)) continue;
    //         vist.add(tmp0.label);
    //         if (tmp0.neighbors != null) {
    //             for (UndirectedGraphNode node0 : tmp0.neighbors) {
    //                 queue0.offer(node0);
    //                 if (!nodes.containsKey(node0.label))
    //                     nodes.put(node0.label, new UndirectedGraphNode(node0.label));
    //                 tmp1.neighbors.add(nodes.get(node0.label));
    //                 queue1.offer(nodes.get(node0.label));
    //             }
    //         }
    //     }
    //     return g;
    // }

    // DFS version
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        UndirectedGraphNode node1 = new UndirectedGraphNode(node.label);
        map.put(node1.label, node1);
        for (UndirectedGraphNode node0 : node.neighbors) {
            if (map.containsKey(node0.label)) {
                node1.neighbors.add(map.get(node0.label));
            } else {
                node1.neighbors.add(cloneGraph(node0));
            }
        }
        return node1;
    }
}
