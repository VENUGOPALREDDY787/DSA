class Solution {
    public int maxOperations(int[] nums, int k) {
        int n = nums.length;
        if(n <=1)return 0;
        Arrays.sort(nums);
        int i = 0;
        int j = n-1;
        int count  = 0;
        while(i<j){
            long sum =(long) nums[i]+ (long)nums[j];
            if(sum == k){
                count++;
                i++;
                j--;
            }else if(sum < k){
                i++;
            }else{
                j--;
            }
        }
        return count;
    }
}