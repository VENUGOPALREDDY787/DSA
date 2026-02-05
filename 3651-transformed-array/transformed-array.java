class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int result[]= new int[n];
        for(int i =0;i<n;i++){
           
            if(nums[i]==0){
                result[i]=nums[i];
            }else{
               int idx = (i + nums[i]) % n;
                if (idx < 0) idx += n;   
                result[i] = nums[idx];
            }
        }
        return result;
    }
}