class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int count  =0;
        int n = fruits.length;
        while(j<n){
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if(map.size()<=2){
                count = Math.max(count,j-i+1);
            }else{
                map.put(fruits[i], map.get(fruits[i])-1);
                if(map.get(fruits[i]) == 0){
                    map.remove(fruits[i]);
                   
                }
                 i++;
            }
            j++;
        }
        return count;
    }
}