class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for(int i = 0; i< nums.length;i++){
            if(i<2 || nums[idx-2]!=nums[i]){
                nums[idx] = nums[i];
                idx++;
            }
        }
        return idx;
    }
}