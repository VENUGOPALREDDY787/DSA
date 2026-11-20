class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int length = 1;
        int[][] dp = new int[n+1][2];
      for(int i=n-1;i>=0;i--){
        for(int inc = 0; inc<2;inc++){
            int res= 1;
            int cur = nums[i]+inc;
            int j =find(i+1,cur+1,nums);
             if(j!= -1){
           res = Math.max(res, 1+dp[j][0]);
          }
          j = find(i+1,cur,nums);
          if(j!=-1){
            res =Math.max(res,1+dp[j][1]);
          }
          dp[i][inc]= res;
          length= Math.max(length,dp[i][inc]);
        }
      }
        return length;
    }
   public static int find(int si, int val, int[] nums) {
    int ei = nums.length;

    while (si < ei) {
        int mid = si + (ei - si) / 2;

        if (nums[mid] >= val) {
            ei = mid;
        } else {
            si = mid + 1;
        }
    }

    if (si < nums.length && nums[si] == val) {
        return si;
    }

    return -1;
}
}