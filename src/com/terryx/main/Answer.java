package com.terryx.main;

import java.util.*;

/**
 * Created by Arvind on 3/18/2017.
 * arvindthirumurthy.com
 */
public class Answer {
    /**
     * Essentially, what we are going to do is build a graph from the starting given 'source' position.
     * We are building the graph by finding each valid possible move position from a certain node and pushing these possibilities into a queue.
     * Then we use BFS to move onto the next node and check for destination else, check for valid move positions there and so on until valid square is found.
     * the number of 'dist' is the number of jumps a node is from the source node.
     * upon finding the destination node, we return the dist number to get path length.
     *
     */
    //Chessboard with constructor to set numbers to each square according to question
    private Integer[][] chessBoard = new Integer[8][8];
    //valid row movements for a Knight
    private int row[] = { 2, 2, -2, -2, 1, 1, -1, -1 };
    //valid column movements for a knight
    private int col[] = { -1, 1, 1, -1, 2, -2, 2, -2 };

    //constructor initializes chessBoard
    Answer() {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = count;
                count++;
            }
        }
    }

    //to check if the next possible move is a valid chessboard coordinate
    private boolean isValidChessBoardCoordinate(int x, int y){
        if (x < 0 || y < 0 || x >= 8 || y >= 8)
        return false;
        return true;
    }
    //Graph node
    static class Node{
        int x; // X coordinate of the node
        int y; // Y coordinate of the node
        int dist; // Distance from source square (graph depth)
        boolean isEqual(Node o){
            return x == o.x && y == o.y;
        }
    }

    /**
     * Alright! the MEAT of the program. BFS takes two nodes (source and destination)
     * and builds a graph by pushing the nodes into a queue.
     * @param src
     * @param dest
     * @return
     */

    int BFS(Node src, Node dest){
        //Hashmap to check if a square was visited before, if so, skip.
        Map<Node,Boolean> visited = new HashMap<>();
        // Queue to push Nodes and pop them for visiting
        Queue<Node> queue = new LinkedList<>();

        queue.add(src);

        while (!queue.isEmpty()){
            Node node = queue.remove();

            int x = node.x;
            int y = node.y;
            int dist = node.dist;

            //if destination reached, return distance
            if (node.isEqual(dest))
                return dist;


            if (visited.get(node) == null)
            {
                visited.put(node, false);
            }
            if (!visited.get(node)) {
                //mark current node as visited
                visited.put(node, true);

                //check for all 8 possible movements
                //and enqueue each valid movement into the queue
                for (int i = 0; i < 8; i++) {
                    int x1 = x + row[i];
                    int y1 = y + col[i];
                    if (isValidChessBoardCoordinate(x1, y1)) {
                        Node n = new Node();
                        n.x = x1;
                        n.y = y1;
                        n.dist = dist + 1;
                        queue.add(n);
                    }

                }
            }


        }
        //return -1 if path is not possible; technically should not happen since every node is reachable and we check for out of bounds before we begin BFS anyway.
        return -1;
    }

    public Integer[] getPosition(int src,int dest){
        Integer[] coordinates = new Integer[4];
        if (src >= 0 && src <= 63 && dest >= 0 && dest <= 63) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessBoard[i][j] == src) {
                        coordinates[0] = j;
                        coordinates[1] = i;
                    }
                    if (chessBoard[i][j] == dest) {
                        coordinates[2] = j;
                        coordinates[3] = i;
                    }
                }
            }
        }else {
            coordinates[0] = -1;
        }

        return coordinates;
    }

    public static int answer2(int src, int dest) {

        Answer answer = new Answer();
        Integer[] coordinates = answer.getPosition(src,dest);
        if (coordinates[0] == -1){
            return -1;
        }
        Answer.Node source = new Node();
        Answer.Node destination = new Node();
        source.x = coordinates[0];
        source.y = coordinates[1];
        destination.x = coordinates[2];
        destination.y = coordinates[3];
        return answer.BFS(source,destination);
    }


}