class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> elemntcounting = new HashMap<>();
         List<Integer> NEW = new ArrayList<>();
        int thresohold = nums.length/3;
        for(int i = 0 ; i< nums.length;i++){
            elemntcounting.put(nums[i],elemntcounting.getOrDefault(nums[i],0)+1);
            int val = elemntcounting.get(nums[i]);
            if(val>thresohold && !NEW.contains(nums[i])){
                NEW.add(nums[i]);
            }
        }
       
    return NEW;
    }
}