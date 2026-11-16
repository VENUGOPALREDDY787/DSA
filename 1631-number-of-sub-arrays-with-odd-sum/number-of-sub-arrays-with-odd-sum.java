class Solution {
    public int numOfSubarrays(int[] nums) {
        int count = 0;
        int mod = 1000000007;
        int even =1;
        int odd = 0;
        int sum = 0;
        for(int i =0; i< nums.length;i++){
            sum =(nums[i]+sum)%mod;
            if(sum%2 == 0){
                count= (count+odd)%mod;
                even++;
            }else{
                count= (count+even)%mod;
                odd++;
            }
        }
        return count;
    }
}