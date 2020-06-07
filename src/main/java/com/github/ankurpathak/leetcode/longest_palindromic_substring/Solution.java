package com.github.ankurpathak.leetcode.longest_palindromic_substring;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        //String str = "babad";
       //String str = "bananas";
        //String str = "cbbd";
      // String str = "c";
        //String str = "";
        String str = "aaaa";
       Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(str));
    }

    public String longestPalindrome(String s) {
        String modified = getModifiesString(s);
        int c = 0, r = 0;
        int actualC = c;
        int len = modified.length();
        int[] p = new int[len];
        int maxLen = 0;
        for(int i = 0; i < len; i++){
            int mirror = (2 * c) - i;
            if(i < r){
                p[i] = Math.min(p[mirror], r - i);
            }
            int a =  i - (p[i] + 1);
            int b =  i + (p[i] + 1);

            while(a >= 0 && b < len && modified.charAt(a) == modified.charAt(b)){
                a--;
                b++;
                p[i] ++;
            }
            if(i + p[i] > r){
                r = i + p[i];
                c = i;
                if(p[i] > maxLen){
                    maxLen = p[i];
                    actualC = c;
                }
            }
        }
        return modified.substring(actualC - p[actualC], actualC + p[actualC]).replaceAll("#","");
    }


    private String getModifiesString(String str){
        StringBuilder modified = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            modified.append("#");
            modified.append(str.charAt(i));
        }
        modified.append("#");
        return modified.toString();
    }
}
