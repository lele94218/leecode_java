package com.terryx.interview.facebook;

import com.terryx.main.RandomListNode;
import com.terryx.main.TreeNode;
import com.terryx.main.UndirectedGraphNode;

import java.util.*;

/**
 * @author taoranxue on 10/18/17 6:33 PM.
 */
public class CloneGraph {
    /**
     * DFS version with hash map
     */
    private Map<UndirectedGraphNode, UndirectedGraphNode> vist = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
        vist.put(node, copyNode);
        for (UndirectedGraphNode nnode : node.neighbors) {
            if (vist.containsKey(nnode)) {
                copyNode.neighbors.add(vist.get(nnode));
            } else {
                copyNode.neighbors.add(cloneGraph(nnode));
            }
        }
        return copyNode;
    }

    /**
     * BFS version with hash map
     */
    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode tmp = queue.poll();
            if (!vist.containsKey(tmp)) {
                vist.put(tmp, new UndirectedGraphNode(tmp.label));
            }
            UndirectedGraphNode copy = vist.get(tmp);
            for (UndirectedGraphNode nnode : tmp.neighbors) {
                if (!vist.containsKey(nnode)) {
                    queue.offer(nnode);
                    vist.put(nnode, new UndirectedGraphNode(nnode.label));
                }
                copy.neighbors.add(vist.get(nnode));
            }
        }
        return vist.get(node);
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            if (!map.containsKey(cur)) {
                map.put(cur, new RandomListNode(cur.label));
            }
            RandomListNode copyNode = map.get(cur);
            if (cur.random != null) {
                if (!map.containsKey(cur.random)) {
                    map.put(cur.random, new RandomListNode(cur.random.label));
                }
                copyNode.random = map.get(cur.random);
            }
            if (cur.next != null) {
                if (!map.containsKey(cur.next)) {
                    map.put(cur.next, new RandomListNode(cur.next.label));
                }
                copyNode.next = map.get(cur.next);
            }

            cur = cur.next;
        }
        return map.get(head);
    }

    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode copy = new TreeNode(root.val);
        copy.left = cloneTree(root.left);
        copy.right = cloneTree(root.right);
        return copy;
    }
}
