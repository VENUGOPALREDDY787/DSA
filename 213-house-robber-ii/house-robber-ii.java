class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        return Math.max(getMax(nums,0,n-2),getMax(nums,1,n-1));
    }
    public int getMax(int nums[], int start,int end){
        int maxSum = 0,prevSum = 0;
        for(int i = start;i<=end;i++){
            int temp = Math.max(maxSum,prevSum+nums[i]);
            prevSum = maxSum;
            maxSum = temp;
        }
        return maxSum;
    }
}