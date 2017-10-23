package com.terryx.gwualgorithm.facebook;

import java.util.*;

/**
 * @author taoranxue on 10/20/17 3:50 PM.
 */
public class RecursionSearch {
    /**
     * Input:Digit string "23"
     * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>(0);
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        dfs(digits, map, 0, new StringBuilder(), ans);
        return ans;
    }

    private void dfs(String digits, String[] map, int cur, StringBuilder path, List<String> ans) {
        if (cur == digits.length()) {
            ans.add(path.toString());
            return;
        }
        int idx = digits.charAt(cur) - '0';
        if (idx <= 9 && idx >= 2) {
            for (int i = 0; i < map[idx].length(); ++i) {
                path.append(map[idx].charAt(i));
                dfs(digits, map, cur + 1, path, ans);
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    /**
     * For example,
     * [1,2,3] have the following permutations:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int state, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i)
            if ((state & (1 << i)) == 0) {
                path.add(nums[i]);
                dfs(nums, state | (1 << i), path, ans);
                path.remove(path.size() - 1);
            }
    }

    /**
     * For example,
     * [1,1,2] have the following unique permutations:
     *
     * [
     * [1,1,2],
     * [1,2,1],
     * [2,1,1]
     * ]
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        Arrays.sort(nums);
        dfs1(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs1(int[] nums, int state, List<Integer> path, List<List<Integer>> ans) {
        if (path.size() == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; ++i)
            if ((state & (1 << i)) == 0) {
                if (i > 0 && nums[i] == nums[i - 1] && (state & (1 << i - 1)) == 0) {
                    continue;
                }
                path.add(nums[i]);
                dfs(nums, state | (1 << i), path, ans);
                path.remove(path.size() - 1);
            }
    }

    /**
     * For example,
     * If nums = [1,2,3], a solution is:
     *
     * [
     * [3],
     * [1],
     * [2],
     * [1,2,3],
     * [1,3],
     * [2,3],
     * [1,2],
     * []
     * ]
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        dfs2(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs2(int[] nums, int cur, List<Integer> path, List<List<Integer>> ans) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, cur + 1, path, ans);
        path.add(nums[cur]);
        dfs(nums, cur + 1, path, ans);
        path.remove(path.size() - 1);
    }

    public List<List<Integer>> subsetsIterative(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; ++i) {
            int size = ans.size();
            for (int j = 0; j < size; j++) {
                List tmpList = new ArrayList<>(ans.get(j));
                tmpList.add(nums[i]);
                ans.add(tmpList);
            }
        }
        return ans;
    }

    /**
     * For example,
     * If nums = [1,2,2], a solution is:
     *
     * [
     * [2],
     * [1],
     * [1,2,2],
     * [2,2],
     * [1,2],
     * []
     * ]
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        Arrays.sort(nums);
        dfs(nums, 0, false, new ArrayList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int cur, boolean choose, List<Integer> path, List<List<Integer>> ans) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        //not choose
        dfs(nums, cur + 1, false, path, ans);
        // choose iff it's the first time to choose or last time have chosen it.
        if (cur > 0 && nums[cur] == nums[cur - 1] && !choose) {
            return;
        }
        path.add(nums[cur]);
        dfs(nums, cur + 1, true, path, ans);
        path.remove(path.size() - 1);
    }

    /**
     * Examples:
     * "123", 6 -> ["1+2+3", "1*2*3"]
     * "232", 8 -> ["2*3+2", "2+3*2"]
     * "105", 5 -> ["1*0+5","10-5"]
     * "00", 0 -> ["0+0", "0-0", "0*0"]
     * "3456237490", 9191 -> []
     */
    public List<List<Integer>> subsetsWithDupIterative(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        Arrays.sort(nums);
        ans.add(new ArrayList<>());
        int size = 0;
        for (int i = 0; i < nums.length; ++i) {
            int start = i > 0 && nums[i] == nums[i - 1] ? size : 0;
            size = ans.size();
            for (int j = start; j < size; ++j) {
                List<Integer> tmpList = new ArrayList<>(ans.get(j));
                tmpList.add(nums[i]);
                ans.add(tmpList);
            }
        }
        return ans;
    }

    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return ans;
        }
        dfs(num, (long) target, 0, 0, 0, "", ans);
        return ans;
    }

    private void dfs(String str, long target, int cur, long res, long suffix, String path, List<String> ans) {
        if (cur == str.length()) {
            if (res == target) {
                ans.add(path);
            }
            return;
        }
        if (cur == 0) {
            long num = 0;
            for (int i = cur; i < str.length(); ++i) {
                if (i == cur + 1 && str.charAt(cur) == '0') {
                    break;
                }
                num = num * 10 + str.charAt(i) - '0';
                dfs(str, target, i + 1, num, num, path + num, ans);
            }
        } else {
            long num = 0;
            for (int i = cur; i < str.length(); ++i) {
                if (i == cur + 1 && str.charAt(cur) == '0') {
                    break;
                }
                num = num * 10 + str.charAt(i) - '0';
                dfs(str, target, i + 1, res + num, num, path + "+" + num, ans);
                dfs(str, target, i + 1, res - num, -num, path + "-" + num, ans);
                dfs(str, target, i + 1, res - suffix + suffix * num, suffix * num, path + "*" + num, ans);
            }
        }
    }
}
