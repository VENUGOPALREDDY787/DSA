class Solution {
    public int longestBalanced(int[] nums) {
        int result = 0;
        for(int i =0;i<nums.length;i++){
            HashMap<Integer,Integer> even =new HashMap<>();
            HashMap<Integer,Integer> odd =new HashMap<>();
            for(int j =i;j<nums.length;j++){
                if(nums[j]%2==0){
                    even.put(nums[j],1);
                }else{
                    odd.put(nums[j],1);
                }

                if(even.size()==odd.size()){
                    result=Math.max(result,j-i+1);
                }
            }
           
        }
        return result;
    }
}