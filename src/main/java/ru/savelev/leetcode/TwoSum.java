package ru.savelev.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] result = test.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> antiMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (antiMap.containsKey(nums[i])) {
                result[0] = antiMap.get(nums[i]);
                result[1] = i;
                return result;
            }
            antiMap.put(target - nums[i], i);
        }
        return result;
    }
}
