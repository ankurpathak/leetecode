package com.github.ankurpathak.leetcode.container_with_most_water;
public class Solution {
    public static void main(String[] args) {
        int [] height = {1,8,6,2,5,4,8,3,7};
        Solution solution =  new Solution();
        System.out.println(solution.maxArea(height));
    }
    public int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0;
        int h = height.length - 1;
        int length = 0;
        while (l < h){
            if(height[l] < height[h]){
                length = height[l];
                maxArea = Math.max(maxArea, length * (h -l));
                l++;
            }else if(height[l] > height[h]){
                length = height[h];
                maxArea = Math.max(maxArea, length * (h -l));
                h--;
            }else {
                length = height[l];
                maxArea = Math.max(maxArea, length * (h -l));
                l++;
                h--;
            }
        }
        return maxArea;
    }
}