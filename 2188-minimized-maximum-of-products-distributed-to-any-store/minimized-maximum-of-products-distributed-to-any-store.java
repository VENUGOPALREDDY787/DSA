class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int end = 0;
        for (int i = 0; i<quantities.length;i++){
            end= Math.max(end, quantities[i]);
        }
        int minmax = Integer.MAX_VALUE;
        int start= 1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int count=0;
            for(int i =0;i<quantities.length;i++){
                if(quantities[i]%mid != 0){
                    count+=(quantities[i]/mid +1);
                }else{
                    count+=(quantities[i]/mid);
                }
             }
             
             if(count <= n){
                minmax= Math.min(minmax,mid);
                end = mid-1;
             }
             else{
                start= mid+1;
             }
             
        }
        return minmax;
    }
}