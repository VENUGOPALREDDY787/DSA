class Solution {
    public int findPeakElement(int[] nums) {
        int si = 0;
        int ei = nums.length-1;
        while(si<ei){
            int mid = si + (ei-si)/2;
           if(nums[mid]>nums[mid+1]){
             ei = mid;
           }
           else{
            si = mid+1;
           }
        }
        return si;
    }
}