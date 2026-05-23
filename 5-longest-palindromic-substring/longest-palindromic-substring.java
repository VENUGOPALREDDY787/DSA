class Solution {
    static int start=0;
    static int end = 0;
    public String longestPalindrome(String s) {
        
        if(s.length()<=1)return s;
        start = 0;
        end = 0;
        helper(s,0);
        return s.substring(start, end + 1);
    }
    public static void helper(String s , int i ){
        if(i>=s.length())return;
        int right = i;
        int left = i;
        while(right<s.length()-1 && s.charAt(right)== s.charAt(right+1))right++;
        while(left>0 && right<s.length()-1&& s.charAt(left-1)== s.charAt(right+1)){
            right++;
            left--;
        }
        if(end-start<right-left){
            end= right;
            start = left;
        }
        helper(s, i+1);
    }
}