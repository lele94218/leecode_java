package com.terryx.gwualgorithm;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author taoranxue on 11/8/16 4:27 PM.
 */
public class Articulation {


    private int V;   // No. of vertices

    // Array  of lists for Adjacency List Representation
    private LinkedList[] adj;
    int time = 0;
    static final int NIL = -1;

    // Constructor
    public Articulation(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);  // Add w to v's list.
        adj[w].add(v);  //Add v to w's list
    }

    // A recursive function that find articulation points using DFS
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    void APUtil(int u, boolean visited[], int disc[],
                int low[], int parent[], boolean ap[]) {

        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        Iterator<Integer> i = adj[u].iterator();
        while (i.hasNext()) {
            int v = i.next();  // v is current adjacent of u

            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            System.out.println(u + " " + v);
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // u is an articulation point in following cases

                // (1) u is root of DFS tree and has two or more children.
                if (parent[u] == NIL && children > 1)
                    ap[u] = true;

                // (2) If u is not root and low value of one of its child
                // is more than discovery value of u.
                if (parent[u] != NIL && low[v] >= disc[u])
                    ap[u] = true;
            }

            // Update low value of u for parent function calls.
            else if (v != parent[u]) {
            //else {
                low[u] = Math.min(low[u], disc[v]);
            }
            /*
             *low[0]: 1, disc[0]: 1
             *low[1]: 1, disc[1]: 2
             *low[2]: 1, disc[2]: 4
             *low[3]: 1, disc[3]: 3
             *low[4]: 3, disc[4]: 5
             *low[5]: 5, disc[5]: 8
             *low[6]: 5, disc[6]: 9
             *low[7]: 5, disc[7]: 6
             *low[8]: 5, disc[8]: 7
             *low[9]: 9, disc[9]: 10
             *
             *low[0]: 1, disc[0]: 1
             *low[1]: 1, disc[1]: 2
             *low[2]: 1, disc[2]: 4
             *low[3]: 1, disc[3]: 3
             *low[4]: 5, disc[4]: 5
             *low[5]: 5, disc[5]: 8
             *low[6]: 5, disc[6]: 9
             *low[7]: 5, disc[7]: 6
             *low[8]: 5, disc[8]: 7
             *low[9]: 10, disc[9]: 10
             */
        }
    }

    // The function to do DFS traversal. It uses recursive function APUtil()
    void AP() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        boolean ap[] = new boolean[V]; // To store articulation points

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++) {
            parent[i] = NIL;
            visited[i] = false;
            ap[i] = false;
        }

        // Call the recursive helper function to find articulation
        // points in DFS tree rooted with vertex 'i'
        for (int i = 0; i < V; i++)
            if (!visited[i])
                APUtil(i, visited, disc, low, parent, ap);

        // Now ap[] contains articulation points, print them
        for (int i = 0; i < V; i++)
            if (ap[i])
                System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < V; ++i) {
            System.out.println("low[" + i + "]: " + low[i] + ", disc[" + i + "]: " + disc[i]);
        }
    }

    // Driver method
    public static void main(String args[]) {
        // Create graphs given in above diagrams

        System.out.println("Articulation points in Third graph ");
        Articulation g3 = new Articulation(10);
        g3.addEdge(0, 1);
        g3.addEdge(0, 2);
        g3.addEdge(0, 3);
        g3.addEdge(3, 1);
        g3.addEdge(2, 1);
        g3.addEdge(2, 3);
        g3.addEdge(3, 4);
        g3.addEdge(4, 7);
        g3.addEdge(4, 8);
        g3.addEdge(7, 8);
        g3.addEdge(4, 5);
        g3.addEdge(5, 6);
        g3.addEdge(4, 6);
        g3.addEdge(9, 6);
        g3.AP();
    }

}
