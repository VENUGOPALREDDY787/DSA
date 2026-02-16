class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n-2;
        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j = n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]= temp;
        }
        revers(nums, i+1,n-1);

    }
    public static void revers(int num[], int start, int end){
        while(start<end){
            int temp = num[start];
            num[start] = num[end];
            num[end]= temp;
            start++;
            end--;
        }
    }
}