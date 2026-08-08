class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0; 
        for(int i = 0; i< nums.length;i++){
            int j = i;
            int m = 0;
            while(j<nums.length){
                if(nums[j] == 0){
                    if(m<k){
                    j++;
                    m++;
                    }else{
                        break;
                    }
                }else{
                    j++;
                }
            }
            max = Math.max(max,j-i);
        }
        return max;
    }
}