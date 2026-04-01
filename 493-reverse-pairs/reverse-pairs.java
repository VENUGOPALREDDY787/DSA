class Solution {
    public int reversePairs(int[] nums) {
        return meargsort(nums,0,nums.length-1);
    }
    public static int meargsort(int[] nums,int start, int end){
        int count = 0;
        if(start>=end)return 0;
       
            int mid = start+(end-start)/2;
            count+=meargsort(nums,start,mid);
            count+=meargsort(nums,mid+1,end);
            count+=countreversepairs(nums,start,mid,end);
            mearg(nums,start,mid,end);
        
        return count;
    }
    public static int countreversepairs(int[] nums,int start,int mid,int end){
        int count = 0;
        int j = mid+1;
        for(int i =start; i<=mid;i++){
            while(j<=end&& (long)2*nums[j]<nums[i]){
                j++;
            }
            count+=j-(mid+1);
        }
        return count;
    }
    public static void mearg(int[] nums,int start,int mid,int end){
        int i = start;
        int j = mid+1;
        int k =0;
        
        int temp[] = new int[end-start+1];
        while(i<=mid && j<=end){
            if(nums[i]<=nums[j]){
                temp[k] = nums[i];
                i++;
                k++;
            }else{
                temp[k] = nums[j];
                k++;
                j++;
            }
        }
        while(i<=mid){
            temp[k] =nums[i];
            i++; 
            k++;
        }
        while(j<=end){
            temp[k] = nums[j];
            j++;
            k++;
        }
        for(k =0;k<temp.length;k++){
            nums[start+k] = temp[k];
        }
        
    }
}