class Solution {
    public long countCommas(long n) {
        int[] list = {3,6,9,12,15};
        long total = 0;
        for(int i = 0; i< list.length;i++){
            
            if(n>=Math.pow(10,list[i])){
                total+=n-(Math.pow(10,list[i])-1);
            }else{
                break;
            }
        }
        return total;
    }
}