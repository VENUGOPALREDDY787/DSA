class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max_val = 2048;
        boolean[] dubleXor = new boolean[max_val];
        boolean[] triplXor = new boolean[max_val];
        for(int i = 0 ; i< nums.length;i++){
            for(int j = i; j<nums.length;j++){
                dubleXor[nums[i]^nums[j]] = true;
            }
        }
        for(int i= 0; i<max_val;i++){
            if(!dubleXor[i])continue;
            for(int v :nums){
                triplXor[i^v] = true;
            }
        }
        int count = 0;
        for(boolean is_there :triplXor ){
            if(is_there)count++;
        }
        return count;
    }
}