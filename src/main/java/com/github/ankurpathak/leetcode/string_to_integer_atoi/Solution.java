package com.github.ankurpathak.leetcode.string_to_integer_atoi;

class Solution {
    public int myAtoi(String str) {
        int i = 0;
        while (i < str.length() && Character.isSpaceChar(str.charAt(i))){
            i++;
        }
        str = str.substring(i);
        if(str.length() <= 0){
            return 0;
        }
        int sign = 1;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            if(str.charAt(0) == '-'){
                sign = -1;
            }
            str = str.substring(1);
            if(str.length() <= 0){
                return 0;
            }
        }
        if(!Character.isDigit(str.charAt(0))){
            return 0;
        }
        int sum = 0;
        i = 0;
        while (i < str.length() && Character.isDigit(str.charAt(i))){
            try{
                sum = Math.addExact(Math.multiplyExact(sum , 10), Integer.parseInt(str.substring(i, i + 1)));
            }catch (ArithmeticException ex){
                if(sign > 0){
                    return Integer.MAX_VALUE;
                }else {
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }
        return sum * sign;
    }

    public static void main(String[] args) {
       // String str = "-42";
        //String str = "42";
       // String str = "4193 with words";
        //String str = "words and 987";
        //String str = "-91283472332";
       // String str = "-";
       // String str = "   -42";
        String str = "+1";
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(str));
    }
}