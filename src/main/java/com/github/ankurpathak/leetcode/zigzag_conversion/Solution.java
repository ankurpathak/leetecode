package com.github.ankurpathak.leetcode.zigzag_conversion;
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1 || numRows >= s.length())
            return s;
        StringBuilder result = new StringBuilder();
        int cycle = 2 * numRows - 2;
        for(int i = 0; i < numRows; i++) {
            int step = cycle - 2 * i;
            for(int j = i; j < s.length(); j+=cycle){
                result.append(s.charAt(j));
                if(step > 0 && step < cycle && j + step < s.length()){
                    result.append(s.charAt(j+step));
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
       // String s = "PAYPALISHIRING"; int  numRows = 3;
       // String s = "PAYPALISHIRING"; int  numRows = 4;
       //String s = "PAYPALISHIRING"; int  numRows = 0;
       //String s = "PAYPALISHIRING"; int  numRows = 1;
       String s = "PAYPALISHIRING"; int  numRows = 15;
        Solution solution = new Solution();
        System.out.println(solution.convert(s,numRows));
    }
}