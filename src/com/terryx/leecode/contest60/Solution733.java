package com.terryx.leecode.contest60;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 1/25/18 4:31 PM.
 */
public class Solution733 {
    int dx[] = new int[]{-1, 1, 0, 0};
    int dy[] = new int[]{0, 0, -1, 1};
    boolean vist[][];

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        vist = new boolean[image.length][image[0].length];
        if (sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length) {
            vist[sr][sc] = true;
            int old = image[sr][sc];
            image[sr][sc] = newColor;
            dfs(image, sr, sc, newColor, old);
        }
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {
        for (int k = 0; k < 4; ++ k) {
            int nx = sr + dx[k], ny = sc + dy[k];
            if (nx >= 0 && nx < image.length && ny >= 0 && ny < image[0].length && !vist[nx][ny] && image[nx][ny] == oldColor) {
                vist[nx][ny] = true;
                image[nx][ny] = newColor;
                dfs(image, nx, ny, newColor, oldColor);
            }
        }
    }

    public static void main(String[] args) {
        Solution733 m = new Solution733();
        int[][] res = m.floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1, 1, 2);
        for (int i = 0; i < res.length; ++ i) {
            System.out.println(Utils.debug(res[i]));
        }
    }
}
