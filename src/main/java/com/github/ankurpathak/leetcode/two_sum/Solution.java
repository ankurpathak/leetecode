package com.github.ankurpathak.leetcode.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (visited.containsKey(delta)) {
                return new int[]{visited.get(delta), i};
            } else {
                visited.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        //int [] nums = { 2, 7, 11, 15}; int target = 9;
        // int [] nums = {0, -1, 2, -3, 1}; int target = -2;
        int[] nums = {1, -2, 1, 0, 5};
        int target = 0;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}
