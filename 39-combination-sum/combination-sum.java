class Solution {
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
       HashSet<List<Integer>> set  = new HashSet<>();
        List<List<Integer>> ml = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        helper(ml,li,0,target,nums,set);
        return ml;
    }
    public static void helper(List<List<Integer>> ml, List<Integer> li, int idx ,int target,int[] nums,HashSet<List<Integer>> set ){
        if(idx == nums.length|| target<0)return;
        if(target == 0 && !set.contains(li)){
            ml.add(new ArrayList<>(li));
            
                
                set.add(new ArrayList<>(li));
            
        }
        li.add(nums[idx]);
        helper(ml,li,idx,target-nums[idx],nums,set);
        helper(ml,li,idx+1,target-nums[idx],nums,set);
        li.remove(li.size()-1);
        helper(ml,li,idx+1,target,nums,set);
    }
}