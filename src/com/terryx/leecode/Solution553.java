package com.terryx.leecode;

import java.util.*;

/**
 * @author taoranxue on 9/5/17 4:11 PM.
 */
public class Solution553 {
    class T {
        public double maxVal = 0.0, minVal = 0.0;
        public String maxStr = "", minStr = "";
    }

    public String optimalDivision(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        Map<Integer, T> maps[] = new Map[nums.length];
        return dfs(0, nums.length - 1, nums, maps).maxStr;
    }

    private T dfs(int start, int end, int[] nums, Map<Integer, T>[] maps) {
        if (maps[start] == null) maps[start] = new HashMap<>();
        if (maps[start].get(end) != null) return maps[start].get(end);
        T ret = new T();
        if (start == end) {
            ret.maxVal = nums[start];
            ret.minVal = nums[start];
            ret.maxStr = nums[start] + "";
            ret.minStr = nums[start] + "";
        } else {
            double maxVal = Double.MIN_VALUE, minVal = Double.MAX_VALUE;
            String maxStr = "", minStr = "";
            for (int i = start; i < end; ++i) {
                T left = dfs(start, i, nums, maps);
                T right = dfs(i + 1, end, nums, maps);
                if (minVal > left.minVal / right.maxVal) {
                    minVal = left.minVal / right.maxVal;
                    minStr = left.minStr + "/" + (i + 1 < end ? "(" : "") + right.maxStr + (i + 1 < end ? ")" : "");
                }

                if (maxVal < left.maxVal / right.minVal) {
                    maxVal = left.maxVal / right.minVal;
                    maxStr = left.maxStr + "/" + (i + 1 < end ? "(" : "") + right.minStr + (i + 1 < end ? ")" : "");
                }
            }
            ret.maxVal = maxVal;
            ret.maxStr = maxStr;
            ret.minVal = minVal;
            ret.minStr = minStr;
        }
        maps[start].put(end, ret);
        return ret;
    }
}
