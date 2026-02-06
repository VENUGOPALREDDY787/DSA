class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int maxsize= 0;
        int j = 0;
        for(int i =0;i<nums.length;i++){ 
            while(j<nums.length && (long)nums[i]*k>=nums[j]){
                j++;
            }
            maxsize=Math.max(maxsize,j-i);
        }
       return nums.length - maxsize;
    }
}