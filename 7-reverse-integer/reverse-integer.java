class Solution {
    public int reverse(int x) {
        int nmbers = x;
        int revernum = 0;
        while(x != 0){
            int remainder = x % 10;
           x = x / 10;
           if(revernum>Integer.MAX_VALUE / 10 ||(revernum==Integer.MAX_VALUE /10 && remainder >7)) return 0;
           if(revernum<Integer.MIN_VALUE / 10 ||(revernum==Integer.MIN_VALUE /10 && remainder < -8)) return 0;
            revernum = remainder + revernum*10;
        }
        
        return revernum;
        
    }
}