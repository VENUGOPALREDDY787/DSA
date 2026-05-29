class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int idx = -1;
        for(int i = 0 ;i< n;i++){
            if(nums[i] == 0){
                idx = i;
            }
        }
        boolean front = true;
        boolean back = true;
        for(int i = 1; i< n;i++){
            if(nums[(idx+i)%n] != i){
                front  = false;
                break;
            }
        }
        for(int i=1;i<n;i++){
            if(nums[(idx-i+n)%n]!=i){
                back=false;
                break;
            }
        }
        if(!front&&!back){
            return -1;
        }
        int res = Integer.MAX_VALUE;
        if(front){
            if(idx==0){
                res=0;
            }
            else{
                res=Math.min(res,idx);
                res=Math.min(res,n-idx+2);
            }
        }if(back){
            res=Math.min(res,n-idx);
            res=Math.min(res,idx+2);
        }
        return res;
    }
}