class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer,Integer> elemntcounting = new HashMap<>();
        for(int i = 0 ; i< nums.length;i++){
            elemntcounting.put(nums[i],elemntcounting.getOrDefault(nums[i],0)+1);
        }
        List<Integer> NEW = new ArrayList<>();
        int thresohold = nums.length/3;
        for(Map.Entry<Integer,Integer>entry:elemntcounting.entrySet()){
            int elemnt = entry.getKey();
            int val = entry.getValue();
            if(val>thresohold){
                NEW.add(elemnt);
            }
        }
    return NEW;
    }
}