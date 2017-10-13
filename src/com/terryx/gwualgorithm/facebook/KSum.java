package com.terryx.gwualgorithm.facebook;

import com.terryx.main.TreeNode;

import javax.lang.model.element.Element;
import java.util.*;

/**
 * @author taoranxue on 10/12/17 2:53 PM.
 */
public class KSum {
    // 2 Sum

    static class Unit {
        int val, index;

        Unit(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    /**
     * Simple version, only one answer.
     * O(n log n) sort
     */
    public int[] twoSumSort(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        List<Unit> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(new Unit(nums[i], i));
        }
        Collections.sort(list, new Comparator<Unit>() {
            public int compare(Unit a, Unit b) {
                return a.val - b.val;
            }
        });
        int i = 0, j = nums.length - 1, cur = 0;
        while (i < j) {
            cur = list.get(i).val + list.get(j).val;
            if (cur == target) {
                return new int[]{list.get(i).index, list.get(j).index};
            }
            if (cur < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }

    /**
     * Simple version, only one answer.
     * O(n) Hash table
     */
    public int[] twoSumHash(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int curVal = nums[i];
            if (map.containsKey(target - curVal)) {
                return new int[]{map.get(target - curVal), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    /**
     * Follow up, multiple answer. O(n)
     */
    public List<List<Integer>> twoSumAllPairsHash(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int curVal = nums[i];
            if (map.containsKey(target - curVal)) {
                List<Integer> list = map.get(target - curVal);
                for (Integer index : list) {
                    ans.add(Arrays.asList(index, i));
                }
            }
            if (!map.containsKey(curVal)) {
                map.put(curVal, new ArrayList<>());
            }
            map.get(curVal).add(i);
        }
        return ans;
    }

    /**
     * Follow up, multiple answer. O(n log n)
     */
    public List<List<Integer>> twoSumAllPairsSort(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        List<Unit> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            list.add(new Unit(nums[i], i));
        }
        Collections.sort(list, new Comparator<Unit>() {
            public int compare(Unit a, Unit b) {
                return a.val - b.val;
            }
        });
        int i = 0, j = nums.length - 1, cur = 0;
        while (i < j) {
            cur = list.get(i).val + list.get(j).val;
            if (cur == target) {
                int leftStart = i, rightStart = j;
                while (list.get(i).val == list.get(leftStart).val) {
                    ++i;
                }
                while (list.get(j).val == list.get(rightStart).val) {
                    --j;
                }
                for (int i0 = leftStart; i0 < i; ++i0) {
                    for (int i1 = rightStart; i1 > j; --i1)
                        if (i0 < i1) {
                            ans.add(Arrays.asList(list.get(i0).index, list.get(i1).index));
                        }
                }
            } else if (cur < target) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }

    /**
     * Follow up, all distinct value pair. O(n log n)
     * <p>
     * Examples
     * <p>
     * A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]
     */
    public List<List<Integer>> allPairsSort(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int curVal = nums[i] + nums[j];
            if (curVal == target) {
                int leftVal = nums[i], rightVal = nums[j];
                ans.add(Arrays.asList(leftVal, rightVal));
                while (i < nums.length && nums[i] == leftVal) {
                    ++i;
                }
                while (j >= 0 && nums[j] == rightVal) {
                    --j;
                }
            } else if (curVal < target) {
                ++i;
            } else {
                --j;
            }
        }
        return ans;
    }

    /**
     * Follow up, all distinct value pair. O(n)
     */
    public List<List<Integer>> allPairsHash(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int curVal = nums[i];
            if (map.containsKey(curVal) && target - curVal == curVal && map.get(curVal) == 1) {
                ans.add(Arrays.asList(curVal, curVal));
            } else if (map.containsKey(target - curVal) && !map.containsKey(curVal)) {
                ans.add(Arrays.asList(curVal, target - curVal));
            }
            if (!map.containsKey(curVal)) {
                map.put(curVal, 1);
            } else {
                map.put(curVal, map.get(curVal) + 1);
            }
        }
        return ans;
    }

    static class BSTIterator {
        boolean min;
        Stack<TreeNode> stack;

        BSTIterator(TreeNode root, boolean min) {
            stack = new Stack<>();
            this.min = min;
            pushAll(root);
        }

        void pushAll(TreeNode cur) {
            while (cur != null) {
                stack.push(cur);
                cur = min ? cur.left : cur.right;
            }
        }

        TreeNode next() {
            TreeNode tmp = stack.pop();
            pushAll(min ? tmp.right : tmp.left);
            return tmp;
        }
    }

    /**
     * Follow up, one answer in BST
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        BSTIterator sBST = new BSTIterator(root, true), lBST = new BSTIterator(root, false);
        TreeNode s = sBST.next(), l = lBST.next();
        while (s != l) {
            int sum = s.val + l.val;
            if (sum == k) {
                return true;
            }
            if (sum < k) {
                s = sBST.next();
            } else {
                l = lBST.next();
            }
        }
        return false;
    }

    // 3 Sum

    /**
     * No duplicate triples should be returned, order of the values in the tuple does not matter
     */
    public List<List<Integer>> allTriples(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        Arrays.sort(nums);
        for (int idx = 0; idx < nums.length - 2; ++idx) {
            if (idx > 0 && nums[idx] == nums[idx - 1]) {
                continue;
            }
            int target0 = target - nums[idx];
            int i = idx + 1, j = nums.length - 1;
            while (i < j) {
                int cur = nums[i] + nums[j];
                if (cur == target0) {
                    ans.add(Arrays.asList(nums[idx], nums[i], nums[j]));
                    while (i + 1 < nums.length && nums[i] == nums[++i]) ;
                    while (j - 1 >= idx + 1 && nums[j] == nums[--j]) ;
                } else if (cur < target0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return ans;
    }

    // 4 Sum

    /**
     * O(n^3)
     */
    public List<List<Integer>> fourSum0(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (k + 1 < nums.length && nums[k] == nums[++k]) ;
                        while (l - 1 >= j + 1 && nums[l] == nums[--l]) ;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;
    }

    static class Pair {
        Integer first, second;

        Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }

        public int hashCode() {
            return this.first.hashCode() + this.second.hashCode();
        }

        public boolean equals(Object d) {
            if (!(d instanceof Pair)) return false;
            Pair p = (Pair) d;
            return this.first == p.first && this.second == p.second;
        }
    }

    /**
     * Best O(n^2) and Worst O(n^3)
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        Map<Integer, Set<Pair>> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int sum = nums[i] + nums[j];
                if (map.containsKey(target - sum)) {
                    Set<Pair> set = map.get(target - sum);
                    for (Pair p : set) {
                        ans.add(Arrays.asList(p.first, p.second, nums[i], nums[j]));
                    }
                }
            }

            for (int j = 0; j < i; ++j) {
                int sum = nums[j] + nums[i];
                if (!map.containsKey(sum)) {
                    map.put(sum, new HashSet<>());
                }
                map.get(sum).add(new Pair(nums[j], nums[i]));
            }
        }
        return new ArrayList<List<Integer>>(ans);
    }

}
