class Solution {
    public int[] singleNumber(int[] nums) {
        int res = 0;
        int[] result = new int[2];
        for(int i = 0; i< nums.length;i++){
            res^=nums[i];
        }
        int bit = res & (-res);
        for(int i = 0; i< nums.length;i++){
            if((bit & nums[i]) == 0){
            result[0]^=nums[i];
            }
        }
        result[1] = res^result[0];
        return result;
    }
}