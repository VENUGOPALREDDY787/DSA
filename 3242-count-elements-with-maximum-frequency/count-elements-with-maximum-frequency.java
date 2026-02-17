class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxfreq=0;
        for(int i =0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
            maxfreq=Math.max(maxfreq,map.get(nums[i]));
        }
        int count=0;
        for(Integer key : map.keySet()){
            if(map.get(key)==maxfreq){
                count++;
            }
        }
        
    return count*maxfreq;
    }
}