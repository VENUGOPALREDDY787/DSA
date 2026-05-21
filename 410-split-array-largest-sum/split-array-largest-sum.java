class Solution {
    public int splitArray(int[] nums, int k) {
        int sum = nums[0];
        int maxelement = nums[0];
        for(int i =1; i<nums.length;i++){
            if(maxelement<nums[i]){
                maxelement = nums[i];
            }
            sum+= nums[i];
        }
        int si = maxelement;
        int ei = sum;
        int minsum = 0;
        while(si<=ei){
            int count = 1;
            int mid = si + (ei-si)/2;
            int ssum = 0;
            for(int i = 0;i< nums.length;i++){
                if(ssum+nums[i]>mid){
                    count++;
                    ssum = nums[i];
                }else{
                    ssum +=nums[i];
                }
            }
            if(count<=k){
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
           return si;
    }
}