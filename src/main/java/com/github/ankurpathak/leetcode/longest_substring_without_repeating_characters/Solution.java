package com.github.ankurpathak.leetcode.longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String str = "";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int len = 0;
        Character c = null;
        Map<Character, Integer> visisted = new HashMap<>();
        for(int j = 0; j < s.length(); j++){
            c = s.charAt(j);
            if(visisted.containsKey(c)){
                i = Math.max(i, visisted.get(c) + 1);
            }
            len = Math.max(len, j - i + 1);
            visisted.put(c, j);
        }
        return len;
    }
}