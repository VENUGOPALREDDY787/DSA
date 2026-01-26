class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        if (k == 1) return 0;
        for(int i =0;i<=nums.length-k;i++){
            int differ = nums[k+i-1]-nums[i];
            minDiff = Math.min(minDiff,differ);
        }
        return minDiff;
    }
}