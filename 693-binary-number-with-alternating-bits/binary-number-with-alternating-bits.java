class Solution {
    public boolean hasAlternatingBits(int n) {
        int bit = n & 1;
       while(n!=0){
        n>>=1;
        int bitmax = n & 1;
        
        if(bitmax == bit){
            return false;
        }
            bit = bitmax;
        
       } 
       return true;
    }
}