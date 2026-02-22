class Solution {
    public int binaryGap(int n) {
        int last = 0;
       
        int max = 0;
        int i =0;
        while(n!=0){
            i++;
            if((n&1)==1){
               if(last !=0){
                max= Math.max(max,i-last);
               }
                last= i;
               
            }
            n>>=1;
        }
        return max;
    }
}