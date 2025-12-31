class Solution {
    public void sortColors(int[] nums) {
        int arr[] = new int[3];
        int j = 0;
        for(int i =0;i<nums.length;i++){
            arr[nums[i]]++;
        }
        for(int i =0;i<arr.length;i++){
            while(arr[i]>0){
                nums[j++] = i;
                arr[i]--;
            }
        }
    }
}