class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int min  = nums[0];
        int sum = 0;
        for(int a : nums){
            sum +=a-min;
        }
    return sum;
    }
}