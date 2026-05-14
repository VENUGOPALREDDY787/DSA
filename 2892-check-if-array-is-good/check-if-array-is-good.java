class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n];
        
       
        for(int num : nums){
            if(num<0 || num>n-1){
                return false;
            }
            freq[num]++;
        }
        for(int i = 1; i<n-1;i++){
            if(freq[i]!=1)return false;
        }

        return freq[n-1] == 2;
    }
}