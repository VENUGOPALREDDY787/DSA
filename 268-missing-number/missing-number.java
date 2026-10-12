class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int bitmas =n ;
        int res = 0;
        for(int i = 0;i< nums.length;i++){
            bitmas=bitmas^i;
            res = res^nums[i];

        }
        return bitmas ^ res;
    }
}