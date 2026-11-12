class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inccount = 1;
        int deccount = 1;
        int max =1;
        for(int i = 1; i< nums.length;i++){
            if(nums[i]>nums[i-1]){
                 deccount =1;
                inccount++;
                max = Math.max(max,inccount);
            }else if(nums[i]<nums[i-1]){
                inccount =1;
                deccount++;
                max = Math.max(max,deccount);
            }else{
                inccount =1;
                deccount =1;
            }
        }
        return max;
    }
}