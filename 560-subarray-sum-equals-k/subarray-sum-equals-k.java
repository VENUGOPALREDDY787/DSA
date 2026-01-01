class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefix[] = new int[nums.length];
        prefix[0]=nums[0];
        int count =0;
        for(int i =1; i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        for(int i= 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                int sum = i==0?prefix[j]:prefix[j]-prefix[i-1];
                if(sum==k)count++;
            }
        }
        return count;
    }
}