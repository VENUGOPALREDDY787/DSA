class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums,k)-atMost(nums,k-1);
    }
    public static int atMost(int[] nums,int k){
        if(k<0)return 0;
        int left = 0;
        int right =0;
        int count = 0;
        int ocount = 0;
        int n = nums.length;
        while(right<n){
            if(nums[right]%2 == 1){
                ocount++;
            }
            while(ocount>k){
                if(nums[left]%2 == 1){
                    ocount--;
                }
                left++;
            }
            count+=right-left+1;
            right++;
        }
        return count;
    }
}