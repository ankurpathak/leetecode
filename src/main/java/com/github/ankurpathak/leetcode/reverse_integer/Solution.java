package com.github.ankurpathak.leetcode.reverse_integer;

public class Solution {
    public int reverse(int x) {
        int reverse = 0;
        while (x != 0){
            /*
           int tempReverse = reverse * 10 + x % 10;
           if(tempReverse / 10 != reverse){
                return 0;
            }
            reverse = tempReverse;
                         */
            try {
                reverse = Math.addExact(Math.multiplyExact(reverse, 10), x %10);
            }catch (ArithmeticException ex){
                return 0;
            }
            x /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
       // int x = 123;
       // int x = -123;
        int x = 120;
        Solution solution =  new Solution();
        System.out.println(solution.reverse(x));
    }
}

// Note: If arithmetic operation produces overflow its counter arithmetic won't give original number
