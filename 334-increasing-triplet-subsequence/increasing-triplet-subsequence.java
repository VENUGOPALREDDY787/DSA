class Solution {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        for(int i = 0; i< nums.length;i++){
            int num = nums[i];
            if(num<=a){
                a = num;
            }else if(num<=b){
                b = num;
            }else{
                return true;
            }
        }
return false;
    }
}