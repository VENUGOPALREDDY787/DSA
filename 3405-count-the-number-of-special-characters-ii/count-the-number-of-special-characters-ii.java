class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i = 0;i< word.length();i++){
            if(Character.isLowerCase(word.charAt(i))){
                map.put(word.charAt(i),i);
            }
        }
        for(int i = 0; i<word.length();i++){
            
            if(!Character.isLowerCase(word.charAt(i))){
                char ch = Character.toLowerCase(word.charAt(i));
                if(map.containsKey(ch)&&map.get(ch)<i && !set.contains(ch)){
                    count++;
                    
                }
                set.add(ch);

            }
        }
        return count;
    }
}