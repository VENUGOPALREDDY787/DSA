class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int n = nums.length;
        int si = 1;
        int ei = nums[n-1];
       while(si<ei){
        int mid = si+(ei-si)/2;
        int val = findresultsum(nums,mid);
        if(val> threshold){
            si = mid+1;
        }else{
            ei= mid;
        }
       }
       return ei;
    }
    public static int findresultsum(int[] nums,int div){
        int sum = 0;
        for(int i = 0; i< nums.length;i++){
            sum += (nums[i] + div - 1) / div;
        }
        return sum ;
    }
}