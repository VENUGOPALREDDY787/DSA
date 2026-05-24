class Solution {

    public int myAtoi(String s) {

        int n = s.length();

        int i = 0;

        int sign = 1;

        long num = 0;

        // 1. Ignore leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {

            if (s.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        // 3. Convert digits
        while (i < n && isDigit(s.charAt(i))) {

            num = num * 10 + (s.charAt(i) - '0');

            // 4. Handle overflow
            if (sign * num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (sign * num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        
        return (int)(sign * num);
    } 
    public boolean isDigit(char ch){
        if(ch<='9'&& ch>='0')return true;
        else{
            return false;
        }
    }
}