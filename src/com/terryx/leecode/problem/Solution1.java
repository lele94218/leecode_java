package com.terryx.leecode.problem;

import java.util.*;

/**
 * @author xueta on 8/25/2016 9:39 AM.
 */
public class Solution1 {

    private class TNumber implements Comparable<TNumber> {
        public TNumber(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        private Integer value;
        private Integer index;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        @Override
        public int compareTo(TNumber o) {
            return this.getValue() - o.getValue();
        }
    }

    public int[] twoSum(int[] nums, int target) {
        List<TNumber> numberList = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            numberList.add(new TNumber(nums[i], i));
        }
        Collections.sort(numberList);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = numberList.get(i).getValue() + numberList.get(j).getValue();
            if (tmp == target) {
                return new int[]{numberList.get(i).getIndex(), numberList.get(j).getIndex()};
            }
            if (tmp > target) j--;
            if (tmp < target) i++;
        }
        return null;
    }
}
