class Solution {
    public int maxProfit(int[] price) {
        int n = price.length;
       int[] left = new int[n];
       int[] right = new int[n];
       int lefts=price[0];
       for(int i = 1; i<n;i++){
        if(price[i]<lefts){
           lefts = price[i];
        }
         left[i] = Math.max(left[i-1],price[i]-lefts);
       }
       int rights = price[n-1];
       for(int i = n-2; i>=0;i--){
        if(price[i]>rights){
            rights = price[i];
        }
        right[i]= Math.max(right[i+1],rights-price[i]);
       }
       int max = 0;
       for(int i = 0 ;i<n;i++){
        max = Math.max(max,right[i]+left[i]);
       }
       return max;
    }
}