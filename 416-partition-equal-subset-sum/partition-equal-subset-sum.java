class Solution {
    public boolean canPartition(int[] nums) {
       int sum = 0;
       int n = nums.length;
       for(int i = 0; i<nums.length;i++){
        sum +=nums[i];
       } 
       if(sum%2 != 0)return false;
       sum/=2;
       int[][] dp= new int[n+1][sum+1];
       for(int i = 1;i<=n;i++){
        for(int j = 1;j<=sum;j++){
            int v = nums[i-1];
            if(j-v>=0){
                dp[i][j] = Math.max(v+dp[i-1][j-v],dp[i-1][j]);
            }else{
                dp[i][j] = dp[i-1][j];
            }
        }
       } 
       return dp[n][sum] == sum?true:false;
    }
}
