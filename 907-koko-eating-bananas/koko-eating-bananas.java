class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high = (int) 1e9;
        while(low<high){
            int mid = low + (high-low)/2;
            if(ispossable(piles,h,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public static boolean ispossable(int[] piles,int h ,int speed){
        int total =0;
        for(int i =0;i< piles.length;i++){
            if(piles[i]<speed)total++;
            else if(piles[i]%speed == 0){
                total+=piles[i]/speed;
            }else{
                total+=piles[i]/speed+1;
            }
        }
        if(total<= h)return true;
        return false;
    }
}