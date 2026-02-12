class Solution {
    public int longestBalanced(String s) {
        HashSet<Character>set = new HashSet<>();
        HashMap<Character,Integer>map = new HashMap<>();
        int max= Integer.MIN_VALUE;
        for(int i =0; i<s.length();i++){
            set.clear();
            map.clear();
            for(int j =i; j<s.length();j++){
                char ch = s.charAt(j);
set.add(ch);

                map.put(ch, map.getOrDefault(ch, 0) + 1);

                int count = map.get(ch);
                boolean flag = true;
                for(Character el : set){
                    if(count!=map.get(el)){
                        flag=false;
                    }
                }
                if(flag==true){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}