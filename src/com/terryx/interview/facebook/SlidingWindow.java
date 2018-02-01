package com.terryx.interview.facebook;

import com.terryx.main.Utils;

import java.util.*;

/**
 * @author taoranxue on 10/13/17 4:19 PM.
 */
public class SlidingWindow {
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!deque.isEmpty() && i - k >= deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) { // If min value change '<' to '>'
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i + 1 >= k) {
                ans.add(nums[deque.peekFirst()]);
            }
        }
        return ans;
    }

    public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int ans[] = new int[nums.length - k + 1], p = 0;
        int sum = 0;
        for (int i = 0; i < k; ++i) {
            sum += nums[i];
        }
        ans[p++] = sum;
        for (int i = k; i < nums.length; ++i) {
            sum -= nums[i - k];
            sum += nums[i];
            ans[p++] = sum;
        }
        return ans;
    }

    /**
     * 在一个array 里面找到 sum最大，长度为 k 的 subarray， 返回sum。
     * 这题太简单应该没算分，但是还让我写了。 第二个 题 找 sum最大，每个长度都是k 的三个subarray。
     * 三个subarray不能有overlap。 举个栗子 1,2,1,2,6,7,5,1。k = 2。
     * 这个里面找到的就应该是[1,2], 1,[2,6],[7,5],1 同样返回和。
     */
    public int findNWindowsWithK(int[] nums, int n, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp[][] = new int[n + 1][nums.length + 1];
        int sum[] = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; ++i) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= nums.length; ++j) {
                dp[i][j] = Math.max((j - k >= 0 ? dp[i - 1][j - k] + sum[j] - sum[j - k] : 0), dp[i][j - 1]);
            }
        }
        for (int i = 0; i <= n; ++i) {
            System.out.println(Utils.debug(dp[i]));
        }
        return dp[n][nums.length - 1];
    }

    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        int map[] = new int[256];
        for (int i = 0; i < t.length(); ++i) {
            map[t.charAt(i)]++;
        }
        int begin = 0, end = 0, len = Integer.MAX_VALUE, start = 0, cnt = t.length();
        for (; end < s.length(); ++end) {
            char c = s.charAt(end);
            if (map[c]-- > 0) { // Note here greater than zero. Special case : ["aa", "aa"];
                cnt--;
            }
            while (cnt == 0) {
                if (len > end - begin + 1) {
                    len = end - begin + 1;
                    start = begin;
                }
                char ic = s.charAt(begin);
                if (map[ic]++ == 0) {
                    cnt++;
                }
                begin++;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || k == 0) return 0;
        int map[] = new int[256];
        int cnt = Math.min(s.length(), k), len = 0, begin = 0, end = 0;
        for (; end < s.length(); ++ end) {
            char c = s.charAt(end);
            if (map[c]++ == 0) {
                cnt--;
            }
            while (cnt < 0) {
                if (map[s.charAt(begin)]-- == 1) {
                    cnt++;
                }
                begin++;
            }
            // Note: check answer here!!!
            len = Math.max(len, end - begin + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        int ans = new SlidingWindow().findNWindowsWithK(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 3, 2);
        System.out.println(ans);
    }
}
