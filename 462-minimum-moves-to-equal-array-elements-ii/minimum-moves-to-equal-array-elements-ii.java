class Solution {
    public int minMoves2(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      int median;
      if(n%2 ==0){
        median = (nums[(n-1)/2]+nums[(n+1)/2])/2;
      }else{
        median = nums[n/2];
      }
      int result = 0;
      for(int i = 0; i< n;i++){
        result+=Math.abs(nums[i]-median);
      }return result;
    }
}