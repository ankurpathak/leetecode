package com.github.ankurpathak.leetcode.regular_expression_matching;

public class Solution {
    public static void main(String[] args) {
       /*String s = "aa";
       String p = "a"; */
       String s = "aab";
       String p = "c*a*b";
       Solution solution = new Solution();
       System.out.println(solution.isMatch(s, p));
    }
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        int n = str.length + 1;
        int m = pattern.length + 1;
        boolean T[][] = new boolean[n][m];
        T[0][0] = true;
        for(int j = 2; j < m; j++){
            if(pattern[j-1]=='*'){
                T[0][j] = T[0][j - 2];
            }
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(str[i -1] == pattern [j - 1] || pattern[j -1] == '.'){
                    T[i][j] = T [i-1][j-1];
                }else if(pattern[j -1] == '*' && j > 1){
                    T[i][j] = T[i][j-2];
                    if(!T[i][j] && (str[i-1]== pattern[j-2] || pattern [j-2] == '.')){
                        T[i][j] =  T[i-1][j];
                    }
                }else {
                    T[i][j] = false;
                }
            }
        }
        return T[n -1][m - 1];
    }
}
