package com.terryx.leecode.problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author taoranxue on 8/5/17 3:29 PM.
 */
public class Solution212 {
    final static int[] dx = new int[]{1, -1, 0, 0};
    final static int[] dy = new int[]{0, 0, -1, 1};

    char[][] board = null;
    boolean[][] vis = null;
    Trie root = null;
    HashSet<String> res = null;

    void dfs(int x, int y, Trie cur) {
        int t = board[x][y] - 'a';
        if (cur.children[t] == null) return;

        // System.out.println(word.toString());
        if (cur.children[t].word != null) {
            // System.out.println("ok!");
            res.add(cur.children[t].word);
        }

        vis[x][y] = true;
        for (int i = 0; i < dx.length; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
                    && !vis[nx][ny]) {
                vis[nx][ny] = true;
                dfs(nx, ny, cur.children[t]);
                vis[nx][ny] = false;
            }
        }
        vis[x][y] = false;

    }


    class Trie {
        Trie[] children;
        String word;
        Trie() {
            children = new Trie[30];
            word = null;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || board.length == 0 || words == null || words.length == 0) return new ArrayList<String>(0);

        root = new Trie();
        res = new HashSet<>();

        for (String word : words) {
            Trie cur = root;
            for (int i = 0; i < word.length(); ++ i) {
                int ch = word.charAt(i) - 'a';
                if (cur.children[ch] == null)
                    cur.children[ch] = new Trie();
                cur = cur.children[ch];
            }
            cur.word = word;
        }

        int height = board.length;
        int width = board[0].length;
        this.board = board;
        this.vis = new boolean[height][width];
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                dfs(i, j, root);
            }
        }
        return new ArrayList<>(res);
    }


}
