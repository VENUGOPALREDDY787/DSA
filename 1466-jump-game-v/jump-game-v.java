class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] dp = new int[n];
    int result = 0;
        for(int i = 0; i<n;i++){
           
result = Math.max(result,dsf(arr,dp,d,i));
        }
        return result;
    } 
    public static int dsf(int[] arr,int[] dp,int d,int i){
        if(dp[i]!= 0)return dp[i];
        int mx = 1;
        int n = arr.length;
        for(int j = 1; j<=d && i+j<n;j++){
            if(arr[i]>arr[i+j]){
                mx = Math.max(mx,1+dsf(arr,dp,d,i+j));
            }else{
                break;
            }
        }
        for(int j =1;j<=d && i-j>=0;j++){
            if(arr[i]>arr[i-j]){
                mx = Math.max(mx,1+dsf(arr,dp,d,i-j));
            }else{
                break;
            }
        }
        dp[i] = mx;
        return dp[i];

    }
}