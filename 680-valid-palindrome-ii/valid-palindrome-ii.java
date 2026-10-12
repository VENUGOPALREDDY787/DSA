class Solution {
    public boolean validPalindrome(String s) {
       int n = s.length();
       int left = 0;
       int right = n-1;
       while(left<right){
        if(s.charAt(left)!=s.charAt(right)){
            if(is_valid(s,left+1,right) || is_valid(s,left,right-1))return true;
            else return false;
        }
        left++;
        right--;
        
       }
       return true;
    }
    public static boolean is_valid(String s ,int left ,int right){
        while(left<right){
        if(s.charAt(left) != s.charAt(right))return false;
        left++;
        right--;
        }

        return true;
    }
}