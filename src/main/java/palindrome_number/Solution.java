package palindrome_number;

class Solution {
    public boolean isPalindrome(final int x) {
        if(x < 0){
            return false;
        }
        if(x > 0 && x % 10 == 0){
            return false;
        }
        int num = x;
        int reverse = 0;
        while (num != 0){
            reverse = reverse * 10 + num % 10;
            num /= 10;
        }
        return x == reverse;
    }

    public static void main(String[] args) {
      //  int x = 121;
       //int x = -121;
       //int x = -10;
       int x = 0;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(x));

    }
}